plugins {
    id("com.android.application")
    id("kotlin-android")
    id("android-plugin")

}

android {
    namespace = "com.hus.data"

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.koin.android)
    implementation(libs.ktor.serialization.gson)
    implementation(libs.ktor.client.cio)
    implementation(project(":core"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}