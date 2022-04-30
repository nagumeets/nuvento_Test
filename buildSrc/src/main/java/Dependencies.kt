object Deps {

    const val application_id = "com.nuvento_test"

    object Versions {
        const val build_tool_version = "30.0.3"
        const val kotlin_jvm_target = "1.8"
        const val compile_sdk = 30
        const val min_sdk = 21
        const val target_sdk = 28
        const val app_version_code = 1
        const val app_version_name = "1.0.0"
        const val android_plugin = "4.1.2"
        const val constraint_layout = "2.0.0-beta4"
        const val lifecycle = "2.3.0"
        const val android_test = "1.2.0"
        const val espresso = "3.2.0"
        const val glide = "4.12.0"
        const val navigation_component = "2.4.0-alpha05"
        const val sdp = "1.0.6"
        const val ssp = "1.0.6"
        const val junit = "4.12"
        const val mockito = "3.2.4"
        const val okhttp = "4.8.0"
        const val retrofit = "2.9.0"
        const val kotlin = "1.5.10"
        const val mockito_kotlin = "2.2.0"
        const val arch_core_testing = "2.0.0"
        const val moshi = "1.11.0"
        const val coroutines = "1.4.2"
        const val annotation = "1.1.0"
        const val ktx_core = "1.3.2"
        const val ktx_fragment = "1.3.0-beta01"
        const val ktx_activity = "1.1.0"
        const val hilt_dagger = "2.34.1-beta"
        const val hilt = "1.0.0-alpha01"
        const val material = "1.3.0"
        const val android_test_junit = "1.1.2"
        const val multidex = "2.0.1"
        const val app_compat = "1.3.0"
        const val jsoup = "1.14.1"
    }

    const val android_plugin = "com.android.tools.build:gradle:${Versions.android_plugin}"

    const val junit = "junit:junit:${Versions.junit}"


    object Google {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    const val jsoup = "org.jsoup:jsoup:${Versions.jsoup}"


    object Kotlin {
        const val gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object AndroidX {
        object Test {
            const val core = "androidx.test:core:${Versions.android_test}"
            const val rules = "androidx.test:rules:${Versions.android_test}"
            const val runner = "androidx.test:runner:${Versions.android_test}"
            const val junit = "androidx.test.ext:junit:${Versions.android_test_junit}"

            object Espresso {
                const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
                const val contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
                const val idling_resource =
                    "androidx.test.espresso:espresso-idling-resource:${Versions.espresso}"
            }

            const val arch_core_testing =
                "androidx.arch.core:core-testing:${Versions.arch_core_testing}"
        }

        const val constraint_layout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"

        const val ktx_core = "androidx.core:core-ktx:${Versions.ktx_core}"
        const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
        const val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.ktx_fragment}"

        object Lifecycle {
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
            const val compiler = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
        }

        object NavigationComponent {
            const val fragment =
                "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_component}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation_component}"
            const val dynamic =
                "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation_component}"
            const val classpath_safe_args =
                "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_component}"
            const val plugin_safe_args = "androidx.navigation.safeargs.kotlin"

        }

        object Hilt {
            const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"
            const val compiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"
        }
    }


    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hilt_dagger}"
        const val android_compiler =
            "com.google.dagger:hilt-android-compiler:${Versions.hilt_dagger}"
        const val gradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_dagger}"

    }

    object Retrofit {
        const val main = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Moshi {
        const val main = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
        const val converter = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    }

    object OkHttp {
        const val main = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val logging_interceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    object Glide {
        const val runtime = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Utility {
        const val sdp = "com.intuit.sdp:sdp-android:${Versions.sdp}"
        const val ssp = "com.intuit.ssp:ssp-android:${Versions.ssp}"
    }

    object Test {
        object Mockito {
            const val core = "org.mockito:mockito-core:${Versions.mockito}"
            const val android = "org.mockito:mockito-android:${Versions.mockito}"
            const val inline = "org.mockito:mockito-inline:${Versions.mockito}"
            const val kotlin =
                "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito_kotlin}"
        }
    }
}
