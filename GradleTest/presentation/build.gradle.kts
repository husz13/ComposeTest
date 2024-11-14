plugins {
    id("com.android.application")
    id("kotlin-android")
    id("android-plugin")

}

android {
    namespace = "com.hus.presentation"

}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}





