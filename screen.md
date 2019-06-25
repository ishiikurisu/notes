# Screen

`Screen` é um programa para a linha de comando do Linux que permite utilizar outras janelas dentro de um mesmo terminal. Em outras palavras: é como se pudéssemos usar abas em qualquer emulador de terminal, inclusive quando estamos acessando outra máquina por `ssh`.

O comando

```
screen -S nova-aba
```

Vai começar uma nova sessão chamada _nova-aba_ no `screen`, a qual vai se parecer com a linha de comando que você já usa. Contudo, alguns comandos novos estarão disponíveis para uso. Para utilizar um comando do `screen`, basta digitar `Ctrl-A` (vou denotar como ⌘A) e  algum dos comandos a seguir:

- ⌘C para criar uma nova tela
- ⌘N e ⌘P para navegar entre as telas
- ⌘" para listar todas as telas abertas
- ⌘D para desafixar uma tela (vulgo sair da tela sem fechá-la, deixa os programas executando)
- `Esc` para entrar no modo de cópia o que te permitirá subir e descer pelo terminal, além de selecionar conteúdo para copiar, recortar e colar

Para terminar uma sessão no `screen`, basta digitar `exit` como se estivesse saindo de uma sessão regular de terminal. Você pode terminar uma sessão do Screen utilizando o comando `screen -X nome-da-sessao`.

Se você sair de uma sessão do `screen` que havia sessões desafixadas, você pode retomá-la com

```
screen -r nome-da-sessao
```
