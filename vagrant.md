# Ruby on Rails + Vagrant"

Este tutorial busca explicar como montar uma _box_ do Vagrant própria para executar aplicações Ruby on Rails. O procedimento básico consiste de:

- Instalar Vagrant
- Instalar e preparar dependências (git, node.js, postgresql, nginx)
- Instalar _gems_ e executar aplicação

## Introdução ##

Antes de tudo, é bom esclarecer uma coisa: [Ruby on Rails](http://rubyonrails.org/) é um _framework_ escrito em [Ruby](https://www.ruby-lang.org/en/) para aplicações _web_. O interessante do Rails é a sua arquitetura, conhecida como Model-View-Controller (MVC), que permite um melhor desacoplamento dos componentes do programa, de tal forma que equipes grandes com pessoas de _backgrounds_ diferentes possam trabalhar na mesma aplicação sem precisar ter uma noção do programa como um todo. Em outras palavras: um designer e um DBA podem trabalhar juntos e ter como conversar sem um precisar conhecer o código do outro.

Este tutorial não busca ensinar Rails, mas sim como preparar o ambiente para executar uma aplicação. Mas não se preocupe: existem vários tutoriais que ensinam este framework! No tempo que escrevi este texto, estava recomendando o tutorial da [Rails Girls](http://railsgirls.com/).

## Instalação do Vagrant ##

Com o Vagrant, podemos desenvolver uma aplicação Ruby on Rails que irá executar na sua máquina local da mesma forma que executará no servidor. No caso, vamos utilizar uma máquina virtual (_VM_ para os íntimos) baseada em Ubuntu, já que
este é o sistema operacional mais comum em provedores de serviços.

Antes de instalar o Vagrant, certifique-se que sua máquina é capaz de instalar e executar o [Virtual Box](https://www.virtualbox.org), já que o Vagrant o usa para simular outros computadores. Com este garantia, baixe e instale o [Vagrant](https://www.vagrantup.com/).

Agora, abra uma instância do seu terminal na pasta onde ficará o seu programa. Nesta janela, digitar o seguintes comando:

    vagrant init ubuntu/trusty64

Note que surgirá uma pasta ˋ.vagrantˋ e um arquivo ˋVagrantfileˋ que cuidarão, respectivamente, de identificar a máquina virtual do Virtual Box associada ao repositório atual e das configurações que o Vagrant deverá usar quando executar a aplicação atual. Por enquanto, queremos somente disponibilizar o acesso à máquina virtual por um endereço na máquina local. Para isso, podemos reescrever o arquivo Vagrantfile da seguinte forma:

    # -*- mode: ruby -*-
    Vagrant.configure("2") do |config|
      config.vm.box = "ubuntu/trusty64"
      config.vm.network "private_network", ip: "77.77.77.7"
    end

Com o Vagrant configurado, agora podemos iniciar a máquina virtual:

    vagrant up

Desta forma, criaremos uma nova VM com Ubuntu na sua máquina local, associá-la-emos ao diretório atual e iniciaremos uma máquina novinha em folha. Depois de baixar e dar _boot_ na VM, podemos acessá-la por meio do seguinte comando:

    vagrant ssh

O seu terminal agora estará acessando a linha de comando do seu novo sistema operacional. Note que ela está vazia! Precisamos prepará-la para que possamos executar uma aplicação em Ruby on Rails vazia! Precisamos prepará-la para que possamos executar uma aplicação em Ruby on Rails.

## Instalação das dependências ##

Uma aplicação Ruby on Rails requer as seguintes dependências:

- Git (programa para versionamento de código, usado ao longo de todo o processo)
- Ruby (Afinal, é a linguagem de programação que utilizaremos)
- Node.js (O Rails usa algumas programas em Javascript para poder gerar as páginas _web_)
- PostgreSQL (Toda aplicação _web_ precisa de um banco de dados, no caso utilizaremos PostgreSQL)
- Nginx (Uma aplicação _web_ precisa ter acesso ao mundo exterior, e é o nginx que fará essa ponte entre as máquinas virtual e local)

No caso, como estamos utilizando o Ubuntu, talvez seja necessário, antes de tudo, atualizar os repositórios o sistema:

    sudo apt-get update

### Instalando o Git

Como a VM que estamos usando é baseada em Ubuntu, a instalação do Git se torna simples:

    sudo apt-get install git

### Instalando Ruby

Para instalar o Ruby, vamos utilizar o [Ruby Version Manager ou _RVM_](https://rvm.io/). Na VM, execute os seguintes comandos:

    gpg --keyserver hkp://keys.gnupg.net --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3 7D2BAF1CF37B13E2069D6956105BD0E739499BDB
    curl -sSL https://get.rvm.io | bash -s stable

e siga as instruções na tela. Com o RVM disponível, instale a versão mais atual do Ruby:

    rvm install ruby



### Instalando Node.js

Uma dependência fundamental do Ruby on Rails é o Node.js, uma _runtime_ para a linguagem Javascript. Ela é usada na interpretação de arquivos que se tornarão as suas páginas _web_. Sua instalação é bastante simples:

    sudo apt-get install nodejs
    sudo apt-get install npm

### Instalando PostgreSQL

Para instalar um servidor PostgreSQL na VM, execute:

     sudo apt-get install postgresql postgresql-contrib

O _setup_ do banco de dados é feito por meio do acesso ao terminal do servidor:

    sudo -u postgre psql

E depedende da aplicação. Para mais informações, acesse este [link da wiki do Ubuntu](https://help.ubuntu.com/community/PostgreSQL).

### Instalando Nginx

Por fim, precisamos permitir que a nossa aplicação possa se comunicar com o mundo exterior (no caso, com o seu computador, que está hospedando uma máquina virtual). Para tanto, vamos utilizar o Nginx. Sua instalação é simples também.

    sudo apt-get install nginx

Ele ainda não está pronto para uso já que alguns ajustes são necessários. No caso, devemos alterar o arquivo de configurações do Nginx (geralmente localizado em `/etc/nginx/nginx.conf`) para ter uma cara próxima à seguinte:

    user www-data;
    worker_processes 4;
    pid /run/nginx.pid;

    events {
         worker_connections 768;
    }

    http {
         server {
              listen 80;
              location / {
                   proxy_pass http://localhost:3000/;
              }
         }
    }

Com o servidor preparado, podemos iniciá-lo com o seguinte comando:

    service nginx start

Se tentar acessar a página `77.77.77.7` do navegador do seu computador (não pela VM), deverá receber um aviso no nginx indicando que não há aplicações funcionando.

## Instalação da aplicação ##

Agora que temos todas as dependências preparadas , podemos trabalhar na aplicação em si.  O primeiro passo é instalar as bibliotecas utilizadas dentro do programa. Para tanto, devemos executar o seguinte comando na pasta raiz (no caso, o diretório ˋ/vagrantˋ da VM):

    bundle install

A própria ferramenta ˋbundleˋ se baseará no arquivo ˋgemfileˋ para saber o que o programa necessita em termos de ferramentas da linguagem. Na primeira execução do programa, também é necessário preparar o banco de dados:

    rake db:migrate

O programa ˋrakeˋ funciona como um "Ruby make" e executa várias ações automáticas para que a aplicação execute corretamente.

Não havendo erros nestes dois últimos passos, basta agora executar o servidor:

    rails server

Pronto! Agora a aplicação _web_ está executando, pronta para ser acessada. No caso, ela está sendo executada dentro da máquina virtual. Para acessá-la na máquina local, abra o seu navegador de preferência e digite o endereço ˋ77.77.77.7ˋ como definimos no arquivo ˋVagrantfileˋ. Se tudo der certo, veremos a página inicial da aplicação.
