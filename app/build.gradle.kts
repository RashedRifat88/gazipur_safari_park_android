plugins {
    id("com.android.application")
}

android {
    namespace = "com.egsystem.gsp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.egsystem.gsp"
        minSdk = 24
        targetSdk = 34
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("androidx.activity:activity:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


//        implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.10.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//    implementation("androidx.navigation:navigation-fragment:2.7.5")
//    implementation("androidx.navigation:navigation-ui:2.7.5")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.legacy:legacy-support-v13:1.0.0")
    implementation("androidx.vectordrawable:vectordrawable:1.1.0")

//    implementation("androidx.navigation:navigation-fragment:2.7.5")
//    implementation("androidx.navigation:navigation-ui:2.7.5")
//    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
//    implementation("androidx.legacy:legacy-support-v4:1.0.0")


    //Room Database
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")


    // Android Architecture Components
    implementation ("androidx.lifecycle:lifecycle-livedata:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.7.0")
    implementation ("android.arch.lifecycle:extensions:1.1.1")

//    // google maps library ------------------------------------------------------------------------
//    implementation("com.google.android.gms:play-services-maps:18.2.0")
//    implementation("com.google.android.libraries.places:places:1.0.0") {
////        exclude module: ")glide")
//    }

    // google gson --------------------------------------------------------------------------------
    implementation("com.google.code.gson:gson:2.10.1")

    // retrofit and RX java dependencies -------------------------------------------------------------------
    implementation("io.reactivex.rxjava2:rxjava:2.2.6")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.5.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")


    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")


    // image loader and dialogs dependencies
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation("com.afollestad.material-dialogs:commons:0.9.6.0")

    //animation lottie
    implementation ("com.airbnb.android:lottie:3.0.0")

    //circle image
    implementation("de.hdodenhof:circleimageview:3.1.0")



}