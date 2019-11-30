# Front In Floripa 2019

7a edição! 2019年11月30日

Introdução
----------

Coisas para ver:
- Vue.js
- Rodrigo Banas no Youtube

Machine Learning com TensorFlow
-------------------------------

Sobre a palestrante:

- @carlaprviera / carlaprv@hotmail.com
- perifacode.com / tecnoGueto.com

Conceitos básicos:

+ Inteligência Artificial: programas que se comportam como o ser humano
+ Aprendizagem de máquinas: programas que dão conta de aprender
+ Deep learning: programas que aprendem com grandes quantidades de dados

Tipos de machine learning:

- Aprendizado supervisionado
  - usa um conjunto inicial para gerar uma rede neural
  - Usa bastante classificação e regressão
- Aprendizado não-supervisionado
  - realiza um agrupamento/associação dos dados por conta própria
  - ???
- aprendizado por reforço
  - auto-explicativo?

Processo de machine learning:

- identificar o problema => definir uma estratégia
- coletar dados para treinar uma máquina
- testar a máquina realizando tarefas
- repetir até ficarmos satisfeitos

Sobre o TensorFlow:

- Tudo são grafos!
- Universal Sentence Encoder
- `import * toxicity from '@tensorflow-models/toxicity'`
- O tensorflow.js roda no navegador!
- `ml5` para desenvolver modelos com uma interface open source amigável para utilizar o tensorflow

> Javascript everywhere!

Limitações do tensorflow.js:

- performance baixa
- a experiência mobile pode ser bem ruim
- problemas éticos -- redes neurais implementam o viés humano! ou seja, podemos ter redes neurais racistas.
- explicabilidade (funciona como caixa preta?)
- só pode usar modelos prontos


Testes para Front-End
---------------------

Sobre o palestrante:

- Mario Souto, engenheiro de software no Nubank
- @omariosouto
- mariosouto.com

Backend:

> A regra de negócio não pode falhar!

Mobile:

> Se você entregar uma versão nova do seu app, sempre existirá um usuário utilizando esta versão.

O front-end precisa garantir toda a experiência do usuário! 
Em outros casos, precisamos garantir também a coleta de métricas.
E se seu app roda offline também? Como fazemos para garantir isto?

> Testes automáticos!

ALguns frameworks de teste UI:

- Selenium
- Cypress
- Pupeteer
- jsdom + DOM testing library
- Enzyme para React
- Test Runner + Jest (e plugins como jest-when, nock)
- Percy -- regressão visual

Testes de UI podem demorar _muito_! Para diminuir o tempo, podemos:

- garantir o "fluxo feliz"! 100% de cobertura é impossível.
- realizar testes de integração
- CI/CD pode ajudar bastante

Pensamentos:

- Qual o custo de um PR parado na sua empresa?
- Better Specs

## A arte da composição

Sobre o palestrante:
- Vitor Mendrone, dev da Work & Co
- @vhmendrone

Programação funcional => código explícito => código melhor

A composição é a essência da programação. Dividimos os problemas grandes em problemas menores para resolvermos.

A composição é a alma da programação funcional (FP).

Quando o código fica muito grande, os efeitos colaterais se tornam invisíveis. Para diminuir isso, podemos usar FP!

Composição é combinar partes e elementos para formar um todo.

Categorias são objetos e os morfismos entre esses objetos. A teoria de categorias tem 3 leis:
- composição
- associatividade
- identidade

Problemas ideais para se resolver por composição:
- null check
- try/catch
- async ops

Tipos funcionais:
- Option<A> -- resultado de uma computação que pode ter uma falha. Permite realizar chains simples
- Either<A, B> -- options com esteroides
- Task<A> -- lazy e referencialmente transparente
- TaskEither<A, B> -- Task + Either = Mônade ==> pode substituir promises!

Coisas:
- Superapps?
- Teoria de categorias?
- fp-ts

Composições simples são flexíveis, robustas, fáceis de entender 


## Painel sobre Carreira

Como estudar UI/UX?

Eu estou preso no "meu mundinho"?

Existe dev full stack?

O maior ativo que uma empresa tem são seus funcionários.


## Flutter

Github: @rubensdemelo (DF dev)

Flutter is Google's portable mobile UI kit.

> Everythong is a widget

Pilares do Flutter:
- desenvolvimento rápido
- UI bonitas e expressivas
- performance nativa

Porque Flutter?
- Google dá suporte
- open source
- alta performance
- comunidade ativa
- documentação muito boa (de acordo com o @rubensdemelo)

Notas:
- Flutter < Dart < Skia (C++) < Binário (Android, iOS, web)
- Tudo está na tela é desenhado na tela usando a biblioteca Skia, que interage diretamente com o Hardware. Isso faz com que, em teoria, o seu app seja mais rápido do que apps feitos, por exemplo, com Ionic, Xamarin, React Native, Kotlin ou Swift.
- Dart é utilizado praticamente só com o Flutter. Lembra o C mas tem suporte a programação assíncrona, FP, entre outros.
- Flutter Create: competição para escrever código Flutter com menos de 5kb.
- Flutter tem suporte a hot reload; hot restart; JIT em dev, AOT em prod; faz uso de widgets para interagir com o desenvolvedor.


## Jamstack

Milson Júnior @mjnr20
Dev na idwall idwall.gupy.io

Jamstack é uma arquitetura moderna, de conteúdo servido sem servidores web. -- Jamstack é um conjunto de ideias.

Jamstack = Javascript + API + Markup

Jamstack contém:
- o time da tecnologia desenvolve HTML+CSS+JS que são enviados para um CDN que proverá o produto ao cliente.
- não há um app monilítico, mas sim um site estático que usa várias APIs diferentes. Há uma pluralidade de tecnologias independentes.
- em termos de infraestrutura, saímos de um app monolítico servido em Docker/Kubernetes difícil de entregar, escalonar e monitorar; para um servidor de arquivos estáticos que já funcionam como uma aplicação e que só precisam de  servidor para casos específicos.

Pipeline Jamstack:
- Desenvolvimento (Gatsby, Next, nuxt.js; controle de versão)
- Build (gerar arquivos estáticos; realizar deploy atômico; invalidação de cache) (headless CMS, backend for frontend, SAAS API (strapi, cockpit, airtable))
- Atualização do CDN (netify)

Casos de reais de implementação:
- Frontend services
- headlesscms.org
- figma.com/developers/api (https://uxdesign.blog.br/design-system-90036c034225)
- Design APIs by Matthew Strom

Armadilhas e pontos fracos:
- https://en.m.wikipedia.org/wiki/Hype_cycle
- Arquivos estáticos podem ser muito grandes!
- CDN ainda é um servidor e ainda precisa de monitoramento.
- "backendificação" do frontend
- dependency hell^2
- SEO é difícil se a aplicação for dinâmica

> Novas tecnologias e estratégias devem ser utilizadas com responsabilidade.

