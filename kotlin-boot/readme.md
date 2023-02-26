## Kotlin boot


### How to start? 
- supported by spring initializer
- or directly from intellij

### Simple example

Simple server with spring data jpa and spring web. 


### Conclusions
- Works fine, easy to set up.  
- Support for kotlin null safety is there but requires plugins
- Not everything integrates with kotling that well. [Example](https://github.com/bastman/spring-kotlin-jooq) jooq generated code is in java and is not null safe 
- Spring 5 supports bean definition kotlin DSL, But... spring boot does not and will not support anytime soon
    - [Example repo](https://github.com/sdeleuze/spring-kotlin-functional/blob/master/src/main/kotlin/functional/Beans.kt)
    - [docs](https://docs.spring.io/spring-framework/docs/5.0.0.RELEASE/spring-framework-reference/kotlin.html#bean-definition-dsl)
    - [future of this](https://github.com/spring-projects-experimental/spring-fu)
```kotlin
fun beans() = beans {
  bean<UserHandler>()
  bean<Routes>()
  bean<WebHandler>("webHandler") {
    RouterFunctions.toWebHandler(
      ref<Routes>().router(),
      HandlerStrategies.builder().viewResolver(ref()).build()
    )
  }
  bean("messageSource") {
    ReloadableResourceBundleMessageSource().apply {
      setBasename("messages")
      setDefaultEncoding("UTF-8")
    }
  }
  bean {
    val prefix = "classpath:/templates/"
    val suffix = ".mustache"
    val loader = MustacheResourceTemplateLoader(prefix, suffix)
    MustacheViewResolver(Mustache.compiler().withLoader(loader)).apply {
      setPrefix(prefix)
      setSuffix(suffix)
    }
  }
  profile("foo") {
    bean<Foo>()
  }
}
```
- Webflux supports functional routing using kotlin DSL, But..... spring web does not and it doesn't seem like it will. Reddit's consensus is webflux is not great
```kotlin
router {
  accept(TEXT_HTML).nest {
    GET("/") { ok().render("index") }
    GET("/sse") { ok().render("sse") }
    GET("/users", userHandler::findAllView)
  }
  "/api".nest {
    accept(APPLICATION_JSON).nest {
      GET("/users", userHandler::findAll)
    }
    accept(TEXT_EVENT_STREAM).nest {
      GET("/users", userHandler::stream)
    }
  }
  resources("/**", ClassPathResource("static/"))
}
```

- most spring stuff integrates with kotlin but... ut ifteb reqyures
