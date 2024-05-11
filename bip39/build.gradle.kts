import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnLockMismatchReport
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

plugins {
    id(libs.plugins.commonMppLib.get().pluginId)
    id(libs.plugins.commonMppPublish.get().pluginId)
}

publishConfig {
    url = "https://maven.pkg.github.com/hieu-dd/clone-kotlin-bip"
    groupId = "dev.kryptonreborn.bip"
    artifactId = "bip39"
}

version = "0.1.0"

android {
    namespace = "dev.kryptonreborn.bip.bip39"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.secureRandom)
                implementation(libs.kotlinCryptoHash)
                implementation(project(BuildModules.CRYPTO))
            }
        }
    }
}

rootProject.plugins.withType<YarnPlugin> {
    rootProject.configure<YarnRootExtension> {
        yarnLockMismatchReport = YarnLockMismatchReport.WARNING
        yarnLockAutoReplace = true
    }
}
