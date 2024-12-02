# Fractais de Fuga do Tempo

<!-- TODO convert this into HTML so I can use mathematical notation here -->

Em termos simples, fractais são imagens que contém _autosimilaridade_, isto
é, elas contém cópias de si mesmas em sua composição. Eles são o exemplo
mais popular de um princípio matemático chamado _recursão_.

Existem várias formas de gerar fractais. Uma das mais fascinantes é os
chamados _algoritmos de fuga do tempo_. Dada uma função, a ideia básica
desses algoritmos é verificar se chamadas consecutivas dessa função são
suficientes para que os seus resultados "explodam" ou não.

Aplicando esta ideia no plano complexo, é possível gerar imagens que
representam os resultados destes algoritmos. É surpreendente pensar que
algoritmos assim gerem imagens com propriedades fractais pois não há
nada intrínseco a eles que possam indicar isto.

## Fractal de Mandelbrot

O fractal mais famoso desta categoria é o _conjunto de Mandelbrot_. Ele
é gerado a partir da seguinte relação:

```
z_(n + 1) = z_(n) ^ 2
```

Para cada ponto no plano imaginário, aplicamos repetidamente a função acima.
Caso as chamadas fujam (neste caso, caso `|z| > 2`), então o ponto não
faz parte do conjunto. Os pontos que formam o conjunto de Mandelbrot
formam o chamado fractal de Mandelbrot:

<!-- TODO gerar fractal de Mandelbrot -->

Ele tem este nome por conta do seu criador, o matematicista
Benoit Mandelbrot. <!-- TODO falar um pouco mais sobre ele -->

## Fractais de Julia

Os conjuntos de Julia são similares ao conjunto de Mandelbrot. Dado um
ponto inicial `c`, podemos gerar o seu conjunto de Julia associado 

```
z_(n + 1) = z_(n) ^ 2 + c
z_0 = 0
```

Existem infinitos fractais de Julia já que existe um conjunto de Julia
para cada ponto no plano complexo.

<!-- TODO generate some examples of Julia fractals -->

Eles foram estudados inicialmente pelos matematicistas franceses
Gaston Julia e Pierre Fatou.

São conhecidas várias propriedades interessantes sobre esta família de
fractais e suas relações com o fractal de Mandelbrot.

Por exemplo: fractais de Julia para um ponto sempre se parecem com a região
ao redor deste mesmo ponto no fratal de Mandelbrot.

<!-- TODO generate images showing how Julia fractals look like zooms in the Mandelbrot set -->

Outra propriedade é que fractais que são gerados por pontos próximos uns
aos outros costumam ser parecidos mas nunca iguais.

<!-- TODO generate GIF of Julia fractals looping -->

## Fractal do Navio Queimando

Existem outras fórmulas que podem ser usadas de maneiras similares ao
conjunto de Mandelbrot. Uma delas é para o chamado "fractal do navio
queimando" (_burning ship fractal_ em inglês), assim nomeado por conta da
sua aparência:

<!-- TODO generate a burning ship fractal -->

## Outros Exemplos

<!-- TODO discover other examples of fractals -->

