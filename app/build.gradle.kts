plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.apollographql.apollo3").version("3.7.3") // 1. graphql plugin
}

// 2. to be added for graphql
apollo {
    service("service") {
        packageName.set("com.example")
    }
}

android {
    namespace = "com.example.graphqldemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.graphqldemo"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // 3. graphql
    implementation("com.apollographql.apollo3:apollo-runtime:3.7.3")

    // viewmodels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
}