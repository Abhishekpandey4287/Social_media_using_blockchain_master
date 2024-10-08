plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.social_media_using_blockchain"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.social_media_using_blockchain"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")
   // implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
   // implementation("androidx.lifecycle:lifecycle-livedata:2.6.2")
   // implementation("androidx.lifecycle:lifecycle-extensions:2.2.0") // Note: Consider alternatives
    implementation("com.google.android.exoplayer:exoplayer-common:2.19.1")
    implementation("com.github.AtifSayings:Animatoo:1.0.1")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}