plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
}

android {
    compileSdkVersion(Versions.Android.COMPILE_SDK)
    buildToolsVersion(Versions.Android.BUILD_TOOLS)

    defaultConfig {
        minSdkVersion(Versions.Android.MIN_SDK)
        targetSdkVersion(Versions.Android.TARGET_SDK)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFile("consumer-rules.pro")
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
    api(Dependencies.Kotlin.KOTLIN_STDLIB)

    api(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APPCOMPAT)
    api(Dependencies.AndroidX.VIEW_BINDING)

    api(Dependencies.GOOGLE.MATERIAL)

    testImplementation(Dependencies.Testing.JUNIT)
    androidTestImplementation(Dependencies.Testing.EXT_JUNIT)
    androidTestImplementation(Dependencies.Testing.ESPRESSO_CORE)

    implementation(Dependencies.Koin.KOIN_CORE)
    implementation(Dependencies.Koin.KOIN_CORE_EXT)
    api(Dependencies.Koin.KOIN_ANDROIDX_VIEW_MODEL)
    api(Dependencies.Koin.KOIN_ANDROIDX_EXT)

    api(Dependencies.GSON)

    implementation(Dependencies.Retrofit.LOGGING_INTERCEPTOR)
    implementation(Dependencies.Retrofit.ADAPTER_RXJAVA2)
    api(Dependencies.Retrofit.RETROFIT)
    implementation(Dependencies.Retrofit.CONVERTER_GSON)

    api(Dependencies.Rxjava.RXJAVA)
    api(Dependencies.Rxjava.RXANDROID)
    api(Dependencies.Rxjava.RXKOTLIN)
}