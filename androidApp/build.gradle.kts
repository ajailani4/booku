plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = AndroidAppConfig.applicationId
    compileSdk = AndroidAppConfig.compileSdk
    defaultConfig {
        applicationId = AndroidAppConfig.applicationId
        minSdk = AndroidAppConfig.minSdk
        targetSdk = AndroidAppConfig.targetSdk
        versionCode = AndroidAppConfig.versionCode
        versionName = AndroidAppConfig.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidAppConfig.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Compose.activity)
    implementation(Koin.android)
    implementation(Koin.compose)
}