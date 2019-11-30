# Caminho para aposentadoria

**Objetivo:** Aposentar-me daqui 10 anos.

**Estratégia:** Juntar dinheiro o suficiente para ter uma renda passiva.

## Definiçōes básicas

Antes de começar a escrever esta nota, vou definir algumas funçōes que serāo
úteis na hora de entender os resultados desta nota.

Primeiro, preciso de uma funçāo para escrever dinheiro na tela para mim:

    putm = (money, currency = '¥') ->
      console.log "#{currency}#{money.toFixed 2}"

Como sabemos, podemos colocar nosso dinheiro para render em alguma forma de
investimento, que rende da seguinte forma:

$$ A = M * (T-1) $$
$$ <=> M = A / (T-1) $$

onde `A` é o que eu vou receber de aposentadoria naquele mês com uma taxa
`T` de rendimento e um montante `M`. Naturalmente, eu posso colocar este
dinheiro para render com juros compostos até o dia da minha aposentadoria:

$$ S = sum_(j=1)^(N) E * (T^(j-1)) $$

onde `S` é o tanto que eu ganho ao final de `N` meses se eu aplicar
`E` dinheiros a uma taxa `T` mensal. Naturalmente, esta taxa muda diariamente
mas eu nāo tenho tempo para modelar isso. Em Coffeescript:

    assess_final_earnings = (e, n, t) ->
      s = 0
      for j in [1..n]
        s += e * Math.pow(t, j - 1)
      return s

Eu também posso descobrir quanto que eu preciso investir todo mês para
ter um determinado saldo:

$$ S = sum_(j=1)^(N) E(T)^(j-1) <=> $$
$$ S = E sum_(j=1)^(N) (1)^(j-1) <=> $$
$$ E = S / (sum_(j=1)^(N) T^(j-1)) $$

Contudo, se olharmos bem para as nossas equaçōes, veremos que o `S` desta
desta é o `M` da outra: o tanto que eu guardar ao final de todo este
tempo tem que o ser o dinheiro que vai render a minha aposentadoria.
Desta forma:

$$ E = A / (T-1) * 1 / (sum_(j=1)^(N) T^j) $$

Transformando isto em Coffeescript:

    assess_required_monthly_investment = (a, n, t) ->
      x = 0
      for j in [1..n]
        x += Math.pow(t, j)
      return a / (t - 1) / x

Agora que temos o básico fora do caminho, vamos discutir a estratégia.


## Sobre o objetivo

Eu quero morar no Japāo e sobreviver com uma renda passiva quando me aposentar.

Eu recebo em reais e quero ganhar ir morar em um lugar que usa o yene como
moeda, entāo acho bom implementar umas funçōes para converter entre moedas:

    to_brl = (jpy) ->
      return jpy / 30
    to_jpy = (brl) ->
      return brl * 30

## Sonhar nāo custa nada

Pelas minhas anotaçōes, eu preciso render ¥5'000'000 por ano.
Vamos supor uma taxa `T = 1.00375`:

    console.log "-- assessing required monthly investment"
    yearly_earnings = 5000000
    monthly_earnings = yearly_earnings / 12
    interest_rate = 1.00375

    a = monthly_earnings
    n = 12 * 10
    t = interest_rate

    required_monthly_investment = assess_required_monthly_investment a, n, t
    putm required_monthly_investment, '¥'
    putm to_brl(required_monthly_investment), 'R$'

    console.log "-- just to be sure... those are the total savings:"
    total_savings = assess_final_earnings required_monthly_investment, n, t
    putm total_savings, '¥'
    putm to_brl(total_savings), 'R$'

    console.log "-- and this is the monthly salary:"
    monthly_retirement = total_savings * (interest_rate - 1)
    putm monthly_retirement
    putm to_brl(monthly_retirement), 'R$'

    console.log "-- and this is the yearly salary:"
    yearly_retirement = monthly_retirement * 12
    putm yearly_retirement
    putm to_brl(yearly_retirement), 'R$'

E é isso! É possível por acaso?

> Fazendo as contas

Eu tive um resultado de R$24000 reais. _Isso é mais do que eu ganho por mês_.

## Quanto eu ganho se juntar o que consigo hoje?

    console.log "-- saving R$1000 every month"
    current_savings = 1000

    e = current_savings
    current_trend = assess_final_earnings e, n, t
    putm current_trend
    putm to_brl(current_trend), 'R$'
    console.log "which is wrong btw"

> Fazendo mais contas

Coffeescript nāo consegue lidar bem com contas em ponto flutuante, está
aparecendo que eu vou juntar somente 5000 ao final de 120 meses?! Movendo
esta soma para o `bc`, eu obtive um montante de R$151198.07. Bem mais razoável.

    console.log "-- saving R$ every month, my 'retirement' would be like this"
    total_savings = 151198.07
    monthly_retirement = total_savings * (interest_rate - 1)
    putm monthly_retirement, 'R$'
    putm to_brl(monthly_retirement)

Ou seja, em 10 anos, eu passaria fome. Nāo é isso que eu quero. Acho que agora
a pergunta se torna:

> Como render R$25000 reais por mês e ainda sobrar dinheiro para viver?

### Como render R$30000/mês

Ou seja, eu preciso ganhar este tanto de dinheiro por mês para que eu possa
criar uma renda passiva muito boa por ano. Como fazer isso?

- "Compound yourself" -- Someone at Brick Abode
- Encontrar uma taxa de juros melhor do que 1.00375

    console.log "-- assessing required monthly investment with 2% interest rate"
    yearly_earnings = 5000000
    monthly_earnings = yearly_earnings / 12
    interest_rate = 1.02

    a = monthly_earnings
    n = 12 * 10
    t = interest_rate

    required_monthly_investment = assess_required_monthly_investment a, n, t
    putm required_monthly_investment, '¥'
    putm to_brl(required_monthly_investment), 'R$'
