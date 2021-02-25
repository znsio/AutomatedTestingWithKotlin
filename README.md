# Mockito for a Kotlin Object
This was a tortured journey for me to discover what to do to create an automated test for a Kotlin object. Perhaps it'll help others shortcut and improve on my experience, I hope so.

## Sources include:

* The article that started the journey https://discuss.kotlinlang.org/t/trying-to-unit-test-an-object/11974/2 Incomplete, incorrect code led to this journey.
* Installing IntelliJ Community Edition (thank you Jetbrains)
* Learning to cope with `build.kotlin.kts` and the subtle effects it had on transcoding examples online.
* IntelliJ doesn't seem to behave like Android Studio even though they share much in common. I lost several hours because the IDE didn't notify me to explicitly sync gradle when I edited `build.kotlin.kts`.
* The *HOW* section of https://site.mockito.org/ is useful, however it used build.gradle syntax. It shouldn't be hard to convert between the two, lack of clear examples took me a long time to find out how to do so.
* Trying to make sense of which packages to include in `build.kotlin.kts` also took a while. This repo has what I ended up with.
* I haven't got as far as applying the following advice, I'll do so at some point https://outadoc.fr/2020/06/converting-gradle-to-gradle-kts/
* This provides a useful walkthrough that'll be worth applying soon for more complex projects  * This provides a useful walkthrough that'll be worth applying soon for more complex projects https://www.petrikainulainen.net/programming/testing/running-kotlin-tests-with-gradle/
* To be able to mock Kotlin objects with Mockito 2.x we need to enable inline mocks https://blog.mindorks.com/mockito-cannot-mock-in-kotlin Another relevant article which helped to fill in gaps in my understanding is https://antonioleiva.com/mockito-2-kotlin/
    * An alternative approach is to use `testImplementation "org.mockito:mockito-inline:$mockito_version"` instead according to: https://medium.com/android-news/quickly-solve-mocking-with-kotlin-551372c285f4
* Git Project Ignore for Kotlin in IntelliJ https://raw.githubusercontent.com/JetBrains/kotlin/master/.gitignore
* 

Some other sources of interest which didn't help directly in my specific instance yet may generally include:

* https://github.com/rozkminiacz/KotlinUnitTesting (it's not been maintained since Oct 2019 so the packages are out of date and examples are not in the build.gradle.kts format).
* https://github.com/junit-team/junit5-samples/tree/main/junit5-jupiter-starter-gradle-kotlin My project happens to use junit4, either that was the default when creating this project in IntelliJ or perhaps the example used it, whereas this example is for core JUnit5.
* https://developerlife.com/2018/10/21/kotlin-testing-setup/ Is a bit dated (2018), for Android rather than pure Kotlin, and uses a different Mockk framework. Otherwise it's a fun read, and the author also has these code examples as part of https://github.com/nazmulidris/places-api-poc
* https://github.com/mockito/mockito-kotlin I use this AFAIK however the README is too brief for me 
