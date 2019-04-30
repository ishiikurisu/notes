Existem vários gerenciadores de bancos de dados disponíveis, mas o meu favorito até o momento é o PostgreSQL: é *open source*, tem bom suporte para imagens e seu *setup* no [Heroku](https://www.heroku.com/) é bem simples. Hoje vou apresentar minha *cheat sheet* para levantar um servidor PostgreSQL (ou PSQL para abreviar) na máquina local para desenvolvimento.

## Instalação

A instalação depende do sistema operacional que você estiver utilizando. Para algumas distribuições Linux:

    sudo pacman -S postgresql # arch
    sudo apt-get install postgresql postgresql-client # debian

Para Windows, basta ir ao [site do programa](https://www.postgresql.org/download/windows/), baixar os executáveis e seguir as instruções em tela.

## Criação de usuários e bancos de dados

Em geral, a instalação do PSQL já cria um usuário chamado `postgres` para a aplicação. Este é um super usuário que é capaz de tudo no seu banco de dados. Para acessar o banco de dados no Linux, use o comando:

    sudo -U postgres psql

No Windows, deve haver um programa chamado `PSQL command line` ou algo nessas linhas instalado que permitirá o mesmo acesso ao programa.

Dentro da linha de comando do PSQL, podemos criar novos usuários e bancos de dados para trabalhar:

    CREATE USER seuusuario WITH PASSWORD 'senha';
    CREATE DATABASE meuprimeirodb OWNER usuario;

Para quem estiver começando, eu recomendo criar um único usuário para utilizar; e um banco de dados por aplicação.

## Comandos básicos

Para acessar o PSQL com o seu usuário na base de dados desejada, use:

    psql -U seuusuario -d meuprimeirodb

Para criar uma nova tabela:

    CREATE TABLE IF NOT EXISTS tabelaqualquer (
      id SERIAL PRIMARY KEY,
      idexterno SERIAL REFERENCES outratabela(id) ON DELETE CASCADE,
      admin BOOLEAN NOT NULL,
      texto VARCHAR(2048) NOT NULL,
      avaliacao INT NOT NULL,
      datainclusao TIMESTAMP WITH TIME ZONE NOT NULL
    );

Para manipular a tabela, não se esqueça dos comandos fundamentais SQL:

    # SELECT
    SELECT * FROM tabela WHERE id='1';

    # INSERT
    INSERT INTO tabela(name,email,password,admin)
    SELECT 'cris','fake@example.com','intrometido?','off'
    WHERE NOT EXISTS (
      SELECT * FROM tabela WHERE email='liberdadeorganizacao@gmail.com')
    RETURNING *;

    # UPDATE
    UPDATE tabela SET email='cris@liberdade.bsb.br' WHERE id='1' RETURNING *;

    # DELETE
    DELETE FROM tabela WHERE id='159' RETURNING *;

## Referências

- [https://wiki.archlinux.org/index.php/PostgreSQL](https://wiki.archlinux.org/index.php/PostgreSQL)
- [https://wiki.debian.org/PostgreSql](https://wiki.debian.org/PostgreSql)
