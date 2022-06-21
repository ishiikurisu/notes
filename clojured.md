# ClojureD Notes

Now called `ClojureU`

# Talks

## Automated Testing

Paulus Esterhazy

- _Festina lente_
- How you manage complexity dictates how long future development will happen.
- Developing microtests is one way to help manage complexity
- End-to-end tests are very dangerous!
- developing microtests is a form of conversational development
  - having a fast feedback loop is key to improve code thus decreasing complexity
- drivers of rising cost of change: brownfielding + bad design
  - changing code is harder than writing new code
  - devs spending most of the time changing code
  - therefore, making changing code easier is the solution to managing complexity
- testability correlates with modifiability


## Automated Correctness Analysis for async code

Sung-Shik

- communicating sequential processes? "CSP proper is amenable to clojure but no work has been done for `core.async` yet"
- mistakes in async code: getting the wiring wrong (wrong results or deadlocks); logic mistakes
- automated corrected analysis (ACA) = check compliance
- ACA = program + instruments + monitoring + specification
- [`discourje`](github.com/discourje) is an instrumentation library


## Let it be

Ariel Alexis

- Java errors have patterns ...and so does Clojure!
- not every error has a pattern


## Beginner Driven Development

- Making things easy should not be a problem. There are correct ways of making things easy though.
- "The better your code is to beginners, the better it is for everyone"
- [Richie talk on simple made easy](https://www.youtube.com/watch?v=LKtk3HCgTa8)


## Building Intelligible Systems

Alys Brooks

- unintelligility impacts everyone: new devs struggle to speed up; more experienced devs forget stuff, or not know everything
- at least document stuff, even if it's bad
- data structures are nice, but it is a good idea to explain what they describe. Examples at how to explain data structures include docstrings, malli, clojure specs, generators, and the `facai` repo.


## Code execution as data with omni-trace

Lukas Domagala

- omni-trace = homoiconic code + interactive introspection
- other similar tools include `clojure.tools.trace` and sayid


## Using macros leads to remorse: an exercise in perversity

Paula Gearon

```
...---...
```

## On Clojure Popularity

Artem Barmin from Freshcode

- idea: treat clojure not as a language, but as a package of developers experiences
- "programming languages are memes"
- pirate funnel: awareness, acquisition, activation, revenue, retention, referral

