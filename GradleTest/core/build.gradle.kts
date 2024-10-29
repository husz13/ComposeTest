plugins {
    id("com.android.application")
    id("kotlin-android")
    id("android-plugin")
}

android {
    namespace = "com.hus.core"


}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.auth)
    implementation(libs.androidx.core.ktx)
    implementation(libs.koin.android)
    implementation(libs.ktor.serialization.gson)
}