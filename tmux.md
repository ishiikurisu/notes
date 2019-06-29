tmux
====

O _Terminal Multiplexer_ (tmux para os íntimos) é um programa para sistemas Unix que permite reorganizar a linha de comando, adicionando janelas e sessões para o terminal.

Aqui, utilizarei o símbolo ⌘ para representar a combinação _prefix_, que é acionada por `ctrl B`.

Acessando o `tmux`
------------------

Para criar uma sessão no `tmux`, digite:

```
tmux  # para simplesmente iniciar o tmux
tmux new -s $nome-da-sessao  # para dar um nome ã sessão
```

Para listar sessões:

```
tmux list-sessions
```

Para voltar a uma sessão desafixada:

```
tmux attach -t $nome-da-sessao
```

Comandos básicos
----------------

- ⌘C cria novas janelas
- ⌘, renomeia janelas
- ⌘N e ⌘P para trocar janelas ("Next" e "Previous")
- ⌘W para listar janelas
- ⌘% e ⌘" divide uma janela vertical e horizontalmente, respectivamente dois paineis.
- ⌘O para mudar para o próximo painel
- ⌘D para desafixar de uma sessão
- ⌘? para listar todos os atalhos
- ⌘: para digitar comandos manualmente

Examplos de comandos manuais:

- `split-window`: divide uma janela horizontalmente
