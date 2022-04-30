import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.parcelize")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id(Deps.AndroidX.NavigationComponent.plugin_safe_args)
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    defaultConfig {
        applicationId = Deps.application_id
        minSdkVersion(Deps.Versions.min_sdk)
        targetSdkVersion(Deps.Versions.target_sdk)
        versionCode = Deps.Versions.app_version_code
        versionName = Deps.Versions.app_version_name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        setProperty("archivesBaseName", "${applicationId}-v${versionName}(${versionCode})")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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
        jvmTarget = Deps.Versions.kotlin_jvm_target
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // Material
    implementation(Deps.Google.material)

    // Android-X

    implementation(Deps.AndroidX.app_compat)
    implementation(Deps.AndroidX.ktx_core)
    implementation(Deps.AndroidX.constraint_layout)
    implementation(Deps.AndroidX.Lifecycle.viewmodel)
    implementation(Deps.AndroidX.multidex)
    implementation(Deps.AndroidX.fragment)

    //Navigation Component
    implementation(Deps.AndroidX.NavigationComponent.fragment)
    implementation(Deps.AndroidX.NavigationComponent.ui)
    implementation(Deps.AndroidX.NavigationComponent.dynamic)

    //Coroutine
    implementation(Deps.Coroutines.core)
    implementation(Deps.Coroutines.android)

    // Hilt
    implementation(Deps.Hilt.android)
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    kapt(Deps.Hilt.android_compiler)

    // Retrofit
    implementation(Deps.Retrofit.main)
    implementation(Deps.Retrofit.moshi)
    implementation(Deps.Retrofit.gson)
    implementation(Deps.OkHttp.logging_interceptor)

    // Moshi
    api(Deps.Moshi.main)
    api(Deps.Moshi.adapters)

    // Glide
    implementation(Deps.Glide.runtime)
    kapt(Deps.Glide.compiler)

    // Utility
    implementation(Deps.Utility.sdp)
    implementation(Deps.Utility.ssp)

    // Unit Test
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.AndroidX.Test.junit)

    // Espresso
    androidTestImplementation(Deps.AndroidX.Test.Espresso.core)

}