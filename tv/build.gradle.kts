import Dependencies.ConfigData.COMPILE_SDK_VERSION
import Dependencies.ConfigData.MIN_SDK_VERSION
import Dependencies.ConfigData.TARGET_SDK_VERSION

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.github.ben-manes.versions")
}

android {
    namespace = "com.rootstrap.tv"
    compileSdk = COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.rootstrap.tv"
        minSdk = MIN_SDK_VERSION
        targetSdk = TARGET_SDK_VERSION
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.COMPOSE_COMPILER
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
    implementation(project(":tv:domain"))
    implementation(project(":tv:data"))
    implementation(project(":core:usecases"))
    implementation(project(":core:di"))

    with(Dependencies.Tv) {
        implementation(LEANBACK)
        implementation(TV_MATERIAL)
        implementation(TV_FOUNDATION)
    }

    with(Dependencies.Compose) {
        implementation(ACTIVITY)
        implementation(UI_TOOLING)
        implementation(UI_TOOLING_PREVIEW)
        implementation(NAVIGATION_COMPOSE)
        implementation(COIL)
        implementation(LIFECYCLE_RUNTIME)
    }

    // Media3
    with(Dependencies.MEDIA) {
        implementation(MEDIA_3)
        implementation(MEDIA_3_SESSION)
        implementation(MEDIA_3_UI)
    }

    implementation(Dependencies.Koin.CORE)
    implementation(Dependencies.Koin.ANDROID)
    implementation(Dependencies.Koin.COMPOSE)
}
