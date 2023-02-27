## Kotlin boot


### How to start? 
- supported by spring initializer
- or directly from intellij

### Simple example

Simple server with spring data jpa and spring web. 


### Conclusions
- Works fine, easy to set up.  
- Support for kotlin null safety is there but requires plugins
- Not everything integrates with kotlin that well. [Example](https://github.com/bastman/spring-kotlin-jooq) ~~jooq generated code is in java and is not null safe~~ [it will be typesafe in 3.18](https://github.com/jOOQ/jOOQ/issues/10212)  
- Spring 5 supports bean definition kotlin DSL, But... spring boot does not and will not support anytime soon
    - [Example repo](https://github.com/sdeleuze/spring-kotlin-functional/blob/master/src/main/kotlin/functional/Beans.kt)
    - [docs](https://docs.spring.io/spring-framework/docs/5.0.0.RELEASE/spring-framework-reference/kotlin.html#bean-definition-dsl)
    - [future of this](https://github.com/spring-projects-experimental/spring-fu)
- Webflux supports functional routing using kotlin DSL, But..... spring web does not and it doesn't seem like it will. Reddit's consensus is webflux is not great
