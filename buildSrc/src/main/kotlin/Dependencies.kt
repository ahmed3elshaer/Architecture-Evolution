const val kotlinVersion = "1.3.50"

object Deps {

    object Versions {
        const val gradlePluginVersion = "3.5.2"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePluginVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val buildToolsVersion = "29.0.2"
    const val target = compile
}

private object Versions {
    const val stepper: String = "1.0.7"
    const val firebaseCore: String = "16.0.5"
    const val RxFirebaseAuth: String = "16.1.0.0"
    const val firebaseRxCore: String = "16.0.5.0"
    const val circularImage: String = "3.0.1"
    const val firebaseRemoteConfig = "16.5.0"
    const val firebaseAnalytics = "16.0.5"
    const val firebaseCrashlytics = "2.10.1"
    const val firebaseStorage = "16.0.1"
    const val firebaseAuth = "16.1.0"
    const val rxandroid = "2.1.1"
    const val dagger = "2.25.2"
    const val dexmaker = "2.12.1"
    const val archTesting = "1.1.1"
    const val mockito = "3.1.0"
    const val hamcrest = "1.3"
    const val moshi = "1.8.0"
    const val glide = "4.10.0"
    const val rxrelay = "2.1.1"
    const val rxjava = "2.2.12"
    const val jetpack = "1.1.0"
    const val material = "1.2.0-alpha02"
    const val navigation = "2.1.0"
    const val constraintLayout = "1.1.3"
    const val lifecycle = "2.1.0"
    const val room = "1.1.1"
    const val retrofit = "2.6.2"
    const val okhttp = "4.2.1"
    const val junit = "4.12"
    const val cameraX = "1.0.0-alpha05"
    const val compression = "2.2.2"
    const val anko = "0.10.8"
}

object JetPack {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.jetpack}"

}

object Camera {
    const val core = "androidx.camera:camera-core:${Versions.cameraX}"
    const val camera2 = "androidx.camera:camera-camera2:${Versions.cameraX}"
    const val cameraView = "com.otaliastudios:cameraview:2.5.0"
    const val cameraKit = "com.wonderkiln:camerakit:0.13.5"
    const val cameraJPEG = "com.camerakit:jpegkit:0.1.0"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.0"
}

object Utils {
    const val compression = "com.iceteck.silicompressorr:silicompressor:${Versions.compression}"
    const val anko = "org.jetbrains.anko:anko-commons:${Versions.anko}"
    const val circularImage = "de.hdodenhof:circleimageview:${Versions.circularImage}"
    const val stepper = "com.github.badoualy:stepper-indicator:${Versions.stepper}"
}

object UI {
    const val material = "com.google.android.material:material:${Versions.material}"
    const val cardview = "androidx.cardview:cardview:${Versions.material}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.material}"
}

object Navigation {
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
}

object Lifecycle {
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
}

object Room {
    const val runtime = "android.arch.persistence.room:runtime:${Versions.room}"
    const val compiler = "android.arch.persistence.room:compiler:${Versions.room}"
    const val rxjava = "android.arch.persistence.room:rxjava2:${Versions.room}"
}

object RxJava {
    val android = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    val java = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val relay = "com.jakewharton.rxrelay2:rxrelay:${Versions.rxrelay}"
}

object Retrofit {
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxjava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
}

object Glide {
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object Moshi {
    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    val kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

}

object UnitTests {
    val jUnit = "junit:junit:${Versions.junit}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    val harmcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"
    val arch = "android.arch.core:core-testing:${Versions.archTesting}"
}

object AndroidTests {
    val dexMaker = "com.linkedin.dexmaker:dexmaker-mockito:${Versions.dexmaker}"
    val jUnit = "junit:junit:${Versions.junit}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
}

object Dagger {
    val runtime = "com.google.dagger:dagger:${Versions.dagger}"
    val android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val support_compiler = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object Firebase {
    val remoteConfig = "com.google.firebase:firebase-config:${Versions.firebaseRemoteConfig}"
    val analytics = "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"
    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.firebaseCrashlytics}"
    val storage = "com.google.firebase:firebase-storage:${Versions.firebaseStorage}"
    val auth = "com.google.firebase:firebase-auth:${Versions.firebaseAuth}"
    val RxAuth = "com.androidhuman.rxfirebase2:firebase-auth:${Versions.RxFirebaseAuth}"
    val RxAuthKotlin = "com.androidhuman.rxfirebase2:firebase-auth-kotlin:${Versions.RxFirebaseAuth}"
    val core = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    val RxCore = "com.androidhuman.rxfirebase2:firebase-core:${Versions.firebaseRxCore}"
}



