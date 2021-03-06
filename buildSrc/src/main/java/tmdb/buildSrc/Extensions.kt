package tmdb.buildSrc

import com.android.build.gradle.internal.dsl.DefaultConfig
import org.gradle.api.Project
import com.android.build.gradle.BaseExtension

fun Project.productFlavorsConfig(defaultConfigExtensions: (DefaultConfig.() -> Unit)? = null) {
    android.run {
        buildTypes {
            getByName("debug") {
                isMinifyEnabled = false
            }
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
                consumerProguardFiles("consumer-rules.pro")
            }
        }

        flavorDimensions(AndroidConfig.flavorDimensions)
        productFlavors {
            create("dev") {
                dimension = "mode"
                buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
                buildConfigField("String", "API_KEY", "\"f433324fbc948dac69b29f7d1aa716a7\"")

            }
            create("prod") {
                buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
                buildConfigField("String", "API_KEY", "\"f433324fbc948dac69b29f7d1aa716a7\"")
                dimension = "mode"
            }
        }
    }
}

val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")