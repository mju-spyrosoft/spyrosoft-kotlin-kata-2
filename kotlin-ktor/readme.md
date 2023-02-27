## Kotlin ktor

Jetbrains framework for kotlin. 

### How to start?
- Intellij  

### Simple example
Simple server with routing and db calls same as with kotlin boot  

### Conclusions
- Everything is explicit. You want something? you have to explicitly state it
- Very little annotation magic good?/bad?. Everything is done **in code**
- Does not come with any dependency injection. Either to it manually or use something for it e.g. [koin](https://insert-koin.io/)
- Built on corutines, no thread per request (like in webflux). Asynchronous from ground up
- Every possible question for spring is already answered by someone in internet. With ktor well...
- Spring is super mature. Ktor is still fairly new
- You have to make decision on which libraries to use for some things but there is less discussion on internets how they perform e.g. how to talk to db? Ktor? Exposed? Jooq?


TODO
- companion objects
- coroutines
