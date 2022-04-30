// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.31")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        jcenter()
    }
    dependencies {
        classpath(Deps.android_plugin)
        classpath(Deps.Kotlin.gradle_plugin)
        classpath(Deps.Hilt.gradlePlugin)
        classpath(Deps.AndroidX.NavigationComponent.classpath_safe_args)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath ("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts files
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven(url = "https://jitpack.io")
    }

    configurations.all {
        resolutionStrategy.eachDependency{
            when {
                requested.name.startsWith("kotlin-stdlib") -> {
                    useTarget(
                            "${requested.group}:${requested.name.replace(
                                    "jre",
                                    "jdk"
                            )}:${requested.version}"
                    )
                }
                else -> when (requested.group) {
                    "org.jetbrains.kotlin" -> useVersion(Deps.Versions.kotlin)
                }
            }
        }
    }
}

tasks.register("clean").configure {
    delete("build")
}