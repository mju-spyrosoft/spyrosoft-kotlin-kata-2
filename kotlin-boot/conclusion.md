### Conclusions

- Works fine, easy to set up.
- Good ol' Spring. Easy to pick up if you already know it.
- Spring is making "some" use of kotlin features like null safety
- Some spring stuff supports kotlin features natively or via plugins.
- Any AOP (that requires class to be "open") that's not handled by provided plugin can be handled using allopen Plugin
- Not everything integrates with kotlin that well. For example JOOQ auto generated schema is ~~all
  nullable~~ [it will be null safe in jooq 3.18](https://github.com/jOOQ/jOOQ/issues/10212)
- Bad ol' Spring. It's not levering some kotling language features like other dedicated frameworks would. Examples
    - Spring 5 supports bean definition kotlin DSL, But... spring boot does not and will not support anytime soon
        - [Example repo](https://github.com/sdeleuze/spring-kotlin-functional/blob/master/src/main/kotlin/functional/Beans.kt)
        - [Docs](https://docs.spring.io/spring-framework/docs/5.0.0.RELEASE/spring-framework-reference/kotlin.html#bean-definition-dsl)
        - [Future of this](https://github.com/spring-projects-experimental/spring-fu)
    - Webflux supports functional routing using kotlin DSL, But..... spring web does not, and it doesn't seem like it
      will.
    - Feels like nulls might will creep in.

- Overall positive experience. **Just** spring boot with kotlin features
