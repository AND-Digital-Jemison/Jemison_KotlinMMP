import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("androidx.test.ext:junit-ktx:1.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    val appCenterSdkVersion = "4.3.1"
    implementation("com.microsoft.appcenter:appcenter-analytics:${appCenterSdkVersion}")
    implementation("com.microsoft.appcenter:appcenter-crashes:${appCenterSdkVersion}")

    // Amplify plugins
    implementation ("com.amplifyframework:core:1.28.3")
    implementation ("com.amplifyframework:aws-api:1.28.3")
    implementation ("com.amplifyframework:aws-datastore:1.28.3")
}


android {

    compileSdk = 31
    ndkVersion = "21.4.7075529"
    val appCenterKey: String =
        if (gradleLocalProperties(rootDir).getProperty("APP_CENTER_KEY_LOCAL") != null) gradleLocalProperties(
            rootDir
        ).getProperty("APP_CENTER_KEY_LOCAL") else "\"noLocalKey\""

    defaultConfig {
        applicationId = "and.jemison.kotlinmmp.android"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "APP_CENTER_KEY_LOCAL", appCenterKey)
        buildConfigField("String", "ENV_NAME", "\"${System.getenv("ENV_NAME")}\"")

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

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.3"
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        androidTestImplementation("androidx.test:runner:1.4.0")

        implementation("androidx.activity:activity-compose:1.4.0")
        implementation("androidx.compose.material:material:1.0.5")
        implementation("androidx.compose.animation:animation:1.0.5")
        implementation("androidx.compose.ui:ui-tooling:1.0.5")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
        androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.5")
        debugImplementation("androidx.compose.ui:ui-test-manifest:1.0.5")

        implementation("com.google.android.material:compose-theme-adapter:1.1.0")
        implementation("com.google.accompanist:accompanist-appcompat-theme:0.16.0")
        implementation("com.google.accompanist:accompanist-pager:0.19.0")
    }

    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}
