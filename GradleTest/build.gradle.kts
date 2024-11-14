// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")

    }
    dependencies {
        classpath(libs.android.pluginGradle)
        classpath(libs.kotlin.pluginGradle)
    }

}
plugins {
    id("com.android.application")  apply false
    id("org.jetbrains.kotlin.android")  apply false
    id("com.android.library")  apply false
}