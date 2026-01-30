plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Añade estas dos líneas:
    id("kotlin-kapt")
    alias(libs.plugins.hilt.gradle)
}

android {
    namespace = "com.transporte.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.transporte.app"
        minSdk = 35
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp.logging)

    // Inyección de Dependencias (Hilt)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler) // Asegúrate de tener el plugin 'kotlin-kapt'

    // Corrutinas (para llamadas asíncronas a la API)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}