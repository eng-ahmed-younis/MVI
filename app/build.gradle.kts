plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.battot.mvi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.battot.mvi"
        minSdk = 27
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

/*    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
                targetCompatibility JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = '17'
    }*/

    buildFeatures {
        dataBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")



    // Dagger-hilt
    val hilt_version = "2.44"
    implementation ("com.google.dagger:hilt-android:$hilt_version")
    kapt ("com.google.dagger:hilt-compiler:$hilt_version")
    // lifecycle with Dagger-Hilt
    ///  implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    // WorkManger with Dagger-Hilt
    implementation ("androidx.hilt:hilt-work:1.0.0")
    // hilt with navigation
    implementation ("androidx.hilt:hilt-navigation-fragment:1.0.0")


    //Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")



    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.squareup.moshi:moshi-kotlin:1.10.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")


   // implementation ("android.arch.lifecycle:viewmodel:1.1.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation ("com.github.bumptech.glide:glide:4.16.0")


 /*   implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
*/

    kapt ("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")

   /* kapt ("com.google.dagger:hilt-compiler:2.42")
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")
*/

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'")


    implementation ("com.squareup.retrofit2:converter-gson:2.1.0")


    // Coroutines and Deferred
    val version_kotlin_coroutines = "1.7.3"
    val version_retrofit_coroutines_adapter = "0.9.2"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$version_kotlin_coroutines")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$version_kotlin_coroutines")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$version_retrofit_coroutines_adapter")


    implementation ("androidx.activity:activity-ktx:1.8.0")

    val lifecycle_version = "2.6.2"
    val arch_version = "2.2.0"


    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
// Lifecycles only (without ViewModel or LiveData)
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")



   // kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.3.0")

    implementation ("androidx.work:work-runtime-ktx:2.7.0")


    //coil
    implementation("io.coil-kt:coil:2.4.0")
}



kapt {
    correctErrorTypes  = true
}