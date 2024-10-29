package com.hus.buildsrc

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
open class AndroidPlugin : Plugin<Project>{
    override fun apply(target: Project) {
       // target.plugins.apply("com.android.library")
        target.android()

    }
   private fun Project.android()= this.extensions.getByType<BaseExtension>()
       .run {
           compileSdkVersion(34)
           defaultConfig {
           //    applicationId = "com.hus.gradletest"
               minSdk = 28

               targetSdk = 34
               testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
               multiDexEnabled = true
               vectorDrawables.useSupportLibrary = true

           }


           compileOptions {
               sourceCompatibility = JavaVersion.VERSION_1_8
               targetCompatibility = JavaVersion.VERSION_1_8
           }

           tasks.withType<KotlinCompile>().configureEach {

               kotlinOptions {
                   jvmTarget = JavaVersion.VERSION_1_8.toString()

               }
           }

       }

}