# GopherCon Brasil 2019

## Palestras

**Dia 1**

### Event-driven archictecture

- Ideia: criar um serviço que recebe eventos de outros serviços para prover processamentos posteriores.
- Evento: precisa da descrição do evento; de metadados sobre a estrutura de dados; e dos dados do evento.
- Existe um design pattern para isto: publisher/subscriber. Em Go, existem bibliotecas para isto: `PubSub`. 
  Precisamos de produtores; consumidores; e uma camada de tráfego. Podemos ter roteadores para distribuir as mensagens entre vários serviços.
- Utilizar o Google Cloud é bem barato! 12 milhões de eventos com eles custa R$150/mês.
- Event drive architecture (EDA) is software that promotes the production and processing of events. Events are a significant change in state.
- Princípios do EDA: escalabilidade; eventualmente consistente; menos cron <=> mais "real-time"; "fire and forget"; foco na informação, não na ação.
- Eventos não viajam! Mensagens que viajam e notificam sobre eventos. Produtores de eventos não precisam saber que existem consumidores e vice-versa.
- Tomar cuidado para não quebrar os consumidores! O schema de dados é muito importante (JSON? BSON? XML?)
- Procurar por "InfoQ archicteture and design 2019 Q1 graph". -- HTTP/3?
- EDA has been deprecated and replaced by the SAGA pattern. -- orquestrador?


### Shifting com Istiops

- Estratégias de deploy: _rolling deploy_; _kernel release_; _with routing_
- **Istio** é um _service mesh_, ou seja, ele vai subir vários serviços com a sua aplicação. Pode te ajudar com várias estratégias de _deploy_ diferentes.
- O Istio utiliza o Kubernetes e pode te ajudar a gerenciar o tráfego da sua aplicação.
- O **IstiOps** é uma aplicação em Go para simplificar o gerenciamento de tráfego do Istio. É _open source_!
- Ideias: pode ser utilizado
- [Apresentação pela Pismo](pismo.io)


### Busca em alta performance com GraphQL e ElasticSearch

Autor: [Guilherme Baptista](github.com/gbaptista)

- Alta performance: baixo tempo de resposta; baixo custo; throughput suportado (requisições por minuto); 
- Mais que 3 segundos de velocidade de resposta => usuários tristes :(
- George Miller: ciência cognitiva; lei de Miller; palácio da memória; psicologia e informação. Ele concluiu em 1968 que: 
  - até 100mil: é instântaneo  -- idealmente, toda requisição deve ser feita em menos que isso
  - até 1s: você acompanha
  - até 10s: você aguarda
  - mais que 10s: você perde a atenção
- [Benchmarks de frameworks populares](www.techempower.com/benchmarks)
- [Should I Rust or should I Go?](codeburst.io)
- ElasticSearch: não tentar o mesmo índice par responder perguntas diferentes; 
  "keyword" ao invés de "text"; scripts são malignos; arredondar datas economiza muito dinheiro;
- Equilíbrio entre alta performance e usabilidade!
- GraphQL: linguagem para fazer buscas em grafos.
- "Os problemas de hoje serão maiores que os de amanhã." "Sempre tem como melhorar." "Nada vai ficar perfeito."
- gRPC em vez de HTTP? Cache no banco de dados? WebAssembly?


### Projeto Shiva

- Qual é o problema mais crítico para um negócio de comunicação?  -- a informação deve chegar rápido!
- O produto de um negócio de comunicação é a mídia (vídeos e podcasts)!
- Ideia do Shiva: a partir de uma plataforma, atualizar todas as plataformas.
- Palestra do Vitor Mendrone: "RangeError: Stack Exceeded"
- RabbitMQ? Realize para Go?
- Docker só funciona se tiver pessoas que entendem de infra na estrutura.


### Análise estática e _linters_

Sugestões:

- "Code Complete" por Steve McConnel -- "You write readable code because it helps other people to read your code"
- `gore` para debugar código.
- `gofmt -s` para simplificar o código, `goimports`, `unident`
- `abcgo`, `gocyclo` (complexidade ciclomática)
- `golint`, `revive`

Características de um bom código:

- Simplicidade: escrever somente o necessário para resolver o seu problema
- Legibilidade: seu código deve ser fácil de entender
- Modularidade: código que pode reutilizado
- _Layering_: attention to the boundaries of each layer
- Design: planejar antes de construir
- Eficiência: usar bem os recursos da máquina
- Elegância: solve problems with proper solutions.
- Clareza: você sabe o que você precisa fazer?

Um bom código balanceia todos estes aspectos!

_Lexer_ converte as frases de um código em várias categorias  e produzir _tokens_. _Parsers_ são? What is a "abstract syntatic tree"?

Homoiconicidade: código é dado, dado é código. Ocorre com linguagens como LISP. Go, por exemplo, não é homoicônico.

ABC metrics servem para indicar o quão complexo é o seu código. ABC vem de "Assignment", "Branch" e "Comparison". 

etcd? grafana?


## Do compilador ao programa

- Computação Ubíqua?
- Compilador: programa que transforma uma linguagem de origem para uma linguagem de destino. 
- Podemos ter um `if` ternário no Go 2.0! Procurar os proposals de mudança no Go.
- Go Compiler Explorer?
- [ ] Implementar o  `vai` (golang em português)
