plugins {
    kotlin("multiplatform").version(Kotlin.kotlinVersion).apply(false)
    kotlin("android").version(Kotlin.kotlinVersion).apply(false)
    id("com.android.application").version("8.0.1").apply(false)
    id("org.jetbrains.kotlin.jvm").version(Kotlin.kotlinVersion).apply(false)
    id("com.android.library").version("8.0.1").apply(false)
    id("org.jetbrains.compose").version("1.4.0").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
