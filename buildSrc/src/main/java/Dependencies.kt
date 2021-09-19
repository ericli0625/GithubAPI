object Versions {
    const val KOTLIN_STDLIB = "1.3.72"

    const val MATERIAL = "1.3.0-alpha03"

    const val CORE_KTX = "1.3.0"
    const val APPCOMPAT = "1.3.0-alpha02"
    const val CONSTRAINT_LAYOUT = "2.1.0"

    const val JUNIT = "4.12"
    const val EXT_JUNIT = "1.1.2"
    const val ESPRESSO = "3.3.0"

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
    }

    object GOOGLE {
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object Testing {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT_JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    }
}