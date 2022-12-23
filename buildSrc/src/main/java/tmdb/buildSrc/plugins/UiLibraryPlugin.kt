package tmdb.buildSrc.plugins

import tmdb.buildSrc.*
import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class UiLibraryPlugin : Plugin<Project> {

    private val Project.android: BaseExtension
        get() = extensions.findByName("android") as? BaseExtension
            ?: error("Not an Android module: $name")

    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            androidConfig()
            productFlavorsConfig()
            dependenciesConfig()
        }
    }

    private fun Project.applyPlugins() {
        plugins.run {
            apply("com.android.library")
            apply("kotlin-android")
            apply("kotlin-parcelize")
            apply("kotlin-kapt")
            apply("dagger.hilt.android.plugin")
        }
    }

    private fun Project.androidConfig() {
        android.run {
            compileSdkVersion(AndroidConfig.compileSdk)
            defaultConfig {
                minSdk = AndroidConfig.minSdk
                targetSdk = AndroidConfig.targetSdk
                versionCode = AndroidConfig.versionCode
                versionName = AndroidConfig.versionName

                testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                sourceCompatibility = AndroidConfig.sourceCompatibility
                targetCompatibility = AndroidConfig.targetCompatibility
            }

            viewBinding.isEnabled = true

            packagingOptions {
                resources {
                    excludes += "META-INF/main.kotlin_module"
                }
            }

            buildFeatures.compose = true

            composeOptions {
                kotlinCompilerExtensionVersion = "1.3.2"
            }
        }
    }

    private fun Project.dependenciesConfig() {
        dependencies {
            "implementation"(Libs.AndroidX.coreKtx)
            "implementation"(Libs.Google.material)
            "implementation"(Libs.Google.flexbox)

            "implementation"(Libs.AndroidX.Lifecycle.viewmodel)
            "implementation"(Libs.AndroidX.Lifecycle.runtime)
            "implementation"(Libs.AndroidX.Paging.runtime)
            "implementation"(Libs.AndroidX.SwipeRefreshLayout.swiperefreshlayout)

            "implementation"(Libs.Hilt.android)
            "kapt"(Libs.Hilt.compiler)

            "implementation"(Libs.Coroutines.android)
            "implementation"(Libs.Coroutines.core)

            "implementation"(Libs.AndroidX.Navigation.fragment)
            "implementation"(Libs.AndroidX.Navigation.uiKtx)


            val composeBom = platform("androidx.compose:compose-bom:2022.12.00")
            "implementation" (composeBom)



            "implementation"("androidx.compose.material3:material3")
            // or Material Design 2
            "implementation"("androidx.compose.material:material")
            // or skip Material Design and build directly on top of foundational components
            "implementation"("androidx.compose.foundation:foundation")
            // or only import the main APIs for the underlying toolkit systems,
            // such as input and measurement/layout
            "implementation"("androidx.compose.ui:ui")

            // Android Studio Preview support
            "implementation"("androidx.compose.ui:ui-tooling-preview")
            "debugImplementation"("androidx.compose.ui:ui-tooling")


            // Optional - Included automatically by material, only add when you need
            // the icons but not the material library (e.g. when using Material3 or a
            // custom design system based on Foundation)
            "implementation"("androidx.compose.material:material-icons-core")
            // Optional - Add full set of material icons
            "implementation"("androidx.compose.material:material-icons-extended")
            // Optional - Add window size utils
            "implementation"("androidx.compose.material3:material3-window-size-class")

            // Optional - Integration with activities
            "implementation"("androidx.activity:activity-compose:1.5.1")
            // Optional - Integration with ViewModels
            "implementation"("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
        }
    }
}