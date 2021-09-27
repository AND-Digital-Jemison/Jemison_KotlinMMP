import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    var appCenterSdkVersion = "4.3.1"
    implementation("com.microsoft.appcenter:appcenter-analytics:${appCenterSdkVersion}")
    implementation("com.microsoft.appcenter:appcenter-crashes:${appCenterSdkVersion}")


    // Amplify plugins
    implementation ("com.amplifyframework:core:1.24.0")
    implementation ("com.amplifyframework:aws-api:1.24.0")
    implementation ("com.amplifyframework:aws-datastore:1.24.0")


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
    signingConfigs {
        create("release") {
            storeFile = file("../app-keystore.jks")
            keyAlias = "app-key"
            storePassword = project.findProperty("storePw") as String?
            keyPassword = project.findProperty("keyPw") as String?
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            buildConfigField("String", "APP_CENTER_KEY_LOCAL", appCenterKey)
        }
    }
}
