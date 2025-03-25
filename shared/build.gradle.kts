plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Kotlin.kotlinVersion
    id("com.android.library")
    id("org.jetbrains.compose")
}

kotlin {
    android()

    jvm("desktop") {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    /*
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    */

    sourceSets {
        val commonMain by getting {
            dependencies {
                // UI
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                api(ImageLoader.imageLoader)

                // Coroutines
                implementation(Coroutines.native)

                // Koin
                implementation(Koin.core)

                // Ktor
                implementation(Ktor.core)
                implementation(Ktor.logging)
                implementation(Ktor.contentNegotiation)
                implementation(Ktor.kotlinJsonSerialization)

                implementation(Kotlin.jsonSerialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Coroutines.test)
            }
        }
        val androidMain by getting {
            dependencies {
                api(AndroidX.appCompat)
                api(AndroidX.coreKtx)

                implementation(Ktor.androidEngine)
            }
        }
        val androidUnitTest by getting

        /*
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        */

        val iosMain by creating {
            dependsOn(commonMain)
            /*
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            */
        }

        /*
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
        */

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)

                implementation(Ktor.cioEngine)
            }
        }
    }
}

android {
    namespace = "com.ajailani.booku"
    compileSdk = 33

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
}