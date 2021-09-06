plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    var appCenterSdkVersion = "4.1.0"
    implementation("com.microsoft.appcenter:appcenter-analytics:${appCenterSdkVersion}")
    implementation("com.microsoft.appcenter:appcenter-crashes:${appCenterSdkVersion}")

}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "and.jemison.kotlinmmp.android"
        minSdkVersion(24)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "APP_CENTER_KEY", "\"dave\"")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}