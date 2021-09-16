import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    var appCenterSdkVersion = "4.3.1"
    implementation("com.microsoft.appcenter:appcenter-analytics:${appCenterSdkVersion}")
    implementation("com.microsoft.appcenter:appcenter-crashes:${appCenterSdkVersion}")
    implementation("com.amplifyframework:core-kotlin:0.2.0")

}

val appCenterKey: String = if (gradleLocalProperties(rootDir).getProperty("APP_CENTER_KEY_LOCAL") != null) gradleLocalProperties(rootDir).getProperty("APP_CENTER_KEY_LOCAL") else "\"noLocalKey\""

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "and.jemison.kotlinmmp.android"
        minSdkVersion(24)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "APP_CENTER_KEY_LOCAL", appCenterKey)
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug") {
            buildConfigField("String", "APP_CENTER_KEY_LOCAL", appCenterKey)
        }
    }
}