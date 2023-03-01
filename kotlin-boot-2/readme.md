## Kotlin boot

### How to start?
- Supported by spring initializer
- Directly from intellij

### Simple example

Simple server with spring data jpa and spring web.

## Conclusions

- Works fine, easy to set up.
- Good ol' Spring. Easy to pick up if you already know it.
- Spring is making "some" use of kotlin features like null safety
- Some spring stuff supports kotlin features natively or via plugins.
- Any AOP (that requires class to be "open") that's not handled by provided plugin can be handled using allopen Plugin
- Not everything integrates with kotlin that well. For example JOOQ auto generated schema is ~~all
  nullable~~ [it will be null safe in jooq 3.18](https://github.com/jOOQ/jOOQ/issues/10212)
- Bad ol' Spring. It's not levering some kotling language features like other dedicated frameworks/orms/libs would. Examples
    - Spring 5 supports bean definition kotlin DSL, But... spring boot does not and will not support anytime soon
        - [Example repo](https://github.com/sdeleuze/spring-kotlin-functional/blob/master/src/main/kotlin/functional/Beans.kt)
        - [Docs](https://docs.spring.io/spring-framework/docs/5.0.0.RELEASE/spring-framework-reference/kotlin.html#bean-definition-dsl)
        - [Future of this](https://github.com/spring-projects-experimental/spring-fu)
    - Webflux supports functional routing using kotlin DSL, But..... spring web does not, and it doesn't seem like it
      will.
    - Feels like nulls might will creep in.

- Overall positive experience. **Just** spring boot with kotlin features


## Kotlin java interop

### What to keep in mind
- Can be added to existing java code with minimal setup.
- There are some quirks that you will have to solve with automatically generated code
- For some reason you cant convert code back to java? 
- Nulls can creep into your database from java code. NPE will be throw on point of entrance
- While kotlin has 100% interop with java you might want to keep interface between kotlin and java fairly small
- Kotlin is not java. They have a lot of similarities, but they are somewhat different languages.
- You are somewhat tied to intellij if you want to use kotlin.
- Slower build

### Read more
- [Docs](https://kotlinlang.org/docs/java-interop.html)
- [Google's Journey from Java to Kotlin for Server Side](https://www.youtube.com/watch?v=o14wGByBRAQ)
- [migrating-apps-from-java-to-kotlin](https://www.krasamo.com/migrating-apps-from-java-to-kotlin/) Has good list of pitfalls why you might not want to do it
- [apps-migrated-from-java-to-kotlin](https://appinventiv.com/blog/apps-migrated-from-java-to-kotlin/)
- [from java to kotlin and back](https://blog.allegro.tech/2018/05/From-Java-to-Kotlin-and-Back-Again.html)

