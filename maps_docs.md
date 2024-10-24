# Guia de Uso do Mapa

Em [crisjr.eng.br/util/map](https://www.crisjr.eng.br/util/map/index.html),
há um mapa interativo que pode ser personalizado para mostrar quaisquer locais
desejados e informações sobre eles.

Alguns dos mapas personalizados que eu criei desta maneira podem ser encontrados
no [meu repositório pessoal](https://www.crisjr.eng.br/maps/).

Além da condição inicial do mapa,
dois tipos de customizações podem ser feitas: "alfinetes" (_pins_) e
"locais" (_places_).

## Condições Iniciais

- `lat`
  - latidude inicial do mapa
- `lon`
  - longitude inicial do mapa
- `zoom`
  - _zoom_ inicial do mapa

## Alfinetes

Os alfinetes deverão ter o seguinte formato:

```
{
  "pin tag": {
    "icon": "home",
    "markerColor": "orange",
    "iconColor": "white",
    "prefix": "fa"
  },
  ...
}
```

Os alfinetes podem conter ícones como definidos no projeto
[Font Awesome](https://fontawesome.com/).
Os valores `icon` e `prefix` devem estar de acordo com o ícone como listado
na página de descrição.

A chave que identifica o alfinete será usada no campo `status` dos locais
que o utilizarão.

Existem dois parâmetros para definir alfinetes:

- `pins`
  - Recebe um objeto JSON
- `pinsurl`
  - Recebe uma URL contendo um objeto JSON

## Locais

Os locais deverão ter o seguinte formato:

```
[
  {
    "lat": -10,
    "lon": 25
    "popup": "Somewhere",
    "status": "pin tag"
  },
  ...
]
```

Onde:

- `lat`
  - Latitude do local
- `lon`
  - Longitude do local
- `popup`
  - Texto apresentado ao selecionar o local
  - Pode conter HTML
- `status`
  - Alfinete utilizado para marcar este local

Existem dois parâmetros que podem ser usados para definir locais:

- `places`
  - Recebe um objeto JSON descrevendo a lista de locais
- `placesurl`
  - Recebe uma URL contendo um objeto JSON assim como `places`
