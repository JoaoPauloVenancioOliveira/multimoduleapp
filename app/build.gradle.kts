plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.movieappyoutube"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.movieappyoutube"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":feature:movie:ui"))
    implementation(project(":feature:movie:domain"))
    implementation(project(":feature:movie:data"))

    implementation(project(":feature:movie_details:ui"))
    implementation(project(":feature:movie_details:domain"))
    implementation(project(":feature:movie_details:data"))

    implementation(project(":core:common"))
    implementation(project(":core:feature_api"))

    implementation(Deps.core)
    implementation(CoroutinesLifecycleScope.lifeCycleRuntime)
    implementation(JetpackCompose.composeActivity)
    implementation(JetpackCompose.composeUi)
    implementation(JetpackCompose.composeUiToolingPreview)
    implementation(JetpackCompose.composeMaterial)
    implementation("androidx.compose.material3:material3:1.1.2")

    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)

    androidTestImplementation(ComposeAndroidTestImplementation.composeUiTest)
    debugImplementation(ComposeDebugImplementation.toolingUi)
    debugImplementation(ComposeDebugImplementation.manifestTest)

    //Hilt
    implementation(DaggerHilt.hilt)
    ksp (DaggerHilt.hiltCompiler)

    //Navigation
    implementation (JetpackCompose.navigation)
}