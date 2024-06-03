
plugins {
    alias(libs.plugins.androidApplication)

}
android {
    namespace = "com.example.capstone_2024"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.capstone_2024"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.core)
    implementation(libs.okhttp)
    implementation(libs.retrofit) //API 불러올때 사용함
    implementation(libs.converter.gson)//API 불러올때 사용함
    implementation("com.github.bumptech.glide:glide:4.12.0")//API 불러올때 사용함
    implementation("com.squareup.retrofit2:converter-simplexml:2.9.0") //xml파싱할때
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


}

