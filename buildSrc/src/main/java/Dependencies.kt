object Versions {
    const val KOTLIN_STDLIB = "1.3.72"

    const val MATERIAL = "1.3.0-alpha03"

    const val CORE_KTX = "1.3.0"
    const val APPCOMPAT = "1.3.0-alpha02"
    const val CONSTRAINT_LAYOUT = "2.1.0"
    const val VIEW_BINDING = "7.0.2"

    const val JUNIT = "4.12"
    const val EXT_JUNIT = "1.1.2"
    const val ESPRESSO = "3.3.0"
    const val CORE_TESTING = "2.1.0"

    const val KOIN = "2.0.1"

    const val GSON = "2.8.8"

    const val LOGGING_INTERCEPTOR = "4.9.0"
    const val ADAPTER_RXJAVA2 = "2.4.0"
    const val RETROFIT = "2.9.0"
    const val CONVERTER_GSON = "2.9.0"

    const val RXJAVA = "2.2.10"
    const val RXANDROID = "2.1.1"
    const val RXKOTLIN = "2.3.0"

    const val FRESCO = "2.3.0"
    const val IMAGE_PIPELINE_OKHTTP = "2.3.0"

    const val MOCKK = "1.12.0"

    const val PAGING = "3.0.1"

    object Android {
        const val COMPILE_SDK = 30
        const val TARGET_SDK = 30
        const val MIN_SDK = 23
        const val BUILD_TOOLS = "30.0.3"
    }
}

object Dependencies {
    object Kotlin {
        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_STDLIB}"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val VIEW_BINDING = "androidx.databinding:viewbinding:${Versions.VIEW_BINDING}"
    }

    object GOOGLE {
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object Testing {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT_JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
        const val CORE_TESTING = "androidx.arch.core:core-testing:${Versions.CORE_TESTING}"
    }

    object Koin {
        const val KOIN_CORE = "org.koin:koin-core:${Versions.KOIN}"
        const val KOIN_CORE_EXT = "org.koin:koin-core-ext:${Versions.KOIN}"
        const val KOIN_ANDROIDX_VIEW_MODEL = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"
        const val KOIN_ANDROIDX_EXT = "org.koin:koin-androidx-ext:${Versions.KOIN}"
    }

    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    object Retrofit {
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR}"
        const val ADAPTER_RXJAVA2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.ADAPTER_RXJAVA2}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.CONVERTER_GSON}"
    }

    object Rxjava {
        const val RXJAVA = "io.reactivex.rxjava2:rxjava:${Versions.RXJAVA}"
        const val RXANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.RXANDROID}"
        const val RXKOTLIN = "io.reactivex.rxjava2:rxkotlin:${Versions.RXKOTLIN}"
    }

    object Fresco {
        const val FRESCO = "com.facebook.fresco:fresco:${Versions.FRESCO}"
        const val IMAGE_PIPELINE_OKHTTP = "com.facebook.fresco:imagepipeline-okhttp3:${Versions.IMAGE_PIPELINE_OKHTTP}"
    }

    object Paging {
        const val RUNTIME_KTX = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
        const val RXJAVA2_KTX = "androidx.paging:paging-rxjava2-ktx:${Versions.PAGING}"
    }

    object Mockk {
        const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
        const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"
    }
}