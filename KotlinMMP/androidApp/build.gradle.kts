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
    implementation("androidx.test.ext:junit-ktx:1.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    val appCenterSdkVersion = "4.3.1"
    implementation("com.microsoft.appcenter:appcenter-analytics:${appCenterSdkVersion}")
    implementation("com.microsoft.appcenter:appcenter-crashes:${appCenterSdkVersion}")
}


android {

    compileSdk = 31
    ndkVersion = "21.4.7075529"
    val appCenterKey: String = if (gradleLocalProperties(rootDir).getProperty("APP_CENTER_KEY_LOCAL") != null) gradleLocalProperties(rootDir).getProperty("APP_CENTER_KEY_LOCAL") else "\"noLocalKey\""

    defaultConfig {
        applicationId = "and.jemison.kotlinmmp.android"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "APP_CENTER_KEY_LOCAL", appCenterKey)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    dependencies {
        androidTestImplementation("androidx.test:runner:1.4.0")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
        implementation("androidx.viewpager2:viewpager2:1.0.0")
    }

}
