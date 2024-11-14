plugins {
   `kotlin-dsl`
    `java-library`
}
gradlePlugin {
    plugins {
        register("android-plugin"){
            id = "android-plugin"
            implementationClass = "com.hus.buildsrc.AndroidPlugin"
        }
    }
}
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}


dependencies {
    //noinspection UseTomlInstead
    implementation("com.android.tools.build:gradle:8.5.2")
    implementation(kotlin("gradle-plugin", "1.9.0"))
    implementation(gradleApi())
    implementation(localGroovy())

}