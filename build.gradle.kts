// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "7.1.0" apply false
    id ("com.android.library") version "7.1.0" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id ("com.google.dagger.hilt.android") version "2.45" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        //classpath("com.google.gms:google-services:4.3.15")
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) { delete(rootProject.buildDir) }
