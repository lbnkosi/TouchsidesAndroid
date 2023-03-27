plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    //id("com.google.gms.google-services")
}

android {
    namespace = "me.lbnkosi.touchsides"
    compileSdk = 33

    defaultConfig {
        applicationId = "me.lbnkosi.touchsides"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName ("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures { dataBinding = true }

    lintOptions { isCheckReleaseBuilds = false }

    hilt { enableExperimentalClasspathAggregation = true }

    packagingOptions {
        exclude("META-INF/gradle/incremental.annotation.processors")
        exclude("META-INF/DEPENDENCIES")
    }
}

dependencies {

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")
    implementation("androidx.core:core-ktx:1.9.0")

    //Android
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Lottie
    implementation("com.airbnb.android:lottie:3.6.0")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

    //Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    //Arch Components
    implementation("androidx.lifecycle:lifecycle-common:2.6.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
    implementation("androidx.fragment:fragment-ktx:1.5.5")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.6.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")

    //Room - https://developer.android.com/jetpack/androidx/releases/room
    kapt("androidx.room:room-compiler:2.5.0") //Kapt
    implementation("androidx.room:room-ktx:2.5.0")
    implementation("androidx.room:room-runtime:2.5.0")
    testImplementation("androidx.room:room-testing:2.5.0") //testImplementation

    //Stetho - https://github.com/facebookarchive/stetho
    implementation("com.facebook.stetho:stetho:1.6.0")
    implementation("com.facebook.stetho:stetho-okhttp3:1.6.0")

    //StreamSupport - https://github.com/stefan-zobel/streamsupport
    implementation("net.sourceforge.streamsupport:streamsupport:1.7.3")

    //Glide - https://github.com/bumptech/glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0") //annotationProcessor

    //Moshi
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    //Multidex
    implementation("androidx.multidex:multidex:2.0.1")


    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:29.1.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-messaging:23.1.2")

    implementation("com.google.dagger:hilt-android:2.45")
    implementation("com.google.dagger:hilt-compiler:2.45")
    implementation("androidx.hilt:hilt-compiler:1.0.0")
    //implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    testImplementation("junit:junit:")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation("org.robolectric:robolectric:4.7.3")


    testImplementation("com.google.truth:truth:1.1.3")

    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation("com.facebook.shimmer:shimmer:0.5.0")

    // For Robolectric tests.
    testImplementation("com.google.dagger:hilt-android-testing:2.45")
    // ...with Kotlin.
    kaptTest("com.google.dagger:hilt-android-compiler:2.45")
    // ...with Java.
    testAnnotationProcessor("com.google.dagger:hilt-android-compiler:2.45")


    // For instrumented tests.
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.45")
    // ...with Kotlin.
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.45")
    // ...with Java.
    androidTestAnnotationProcessor("com.google.dagger:hilt-android-compiler:2.45")

    //debugImplementation("com.amitshekhar.android:debug-db:1.0.6")
    //implementation("com.amitshekhar.android:debug-db:1.0.6")
}