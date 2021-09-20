plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
}

android {
    compileSdkVersion(Versions.Android.COMPILE_SDK)
    buildToolsVersion(Versions.Android.BUILD_TOOLS)

    defaultConfig {
        applicationId = "com.example.githubapi"
        minSdkVersion(Versions.Android.MIN_SDK)
        targetSdkVersion(Versions.Android.TARGET_SDK)

        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":base"))

    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)

    testImplementation(Dependencies.Testing.JUNIT)
    androidTestImplementation(Dependencies.Testing.EXT_JUNIT)
    androidTestImplementation(Dependencies.Testing.ESPRESSO_CORE)
}