val forgeGradleVersion: String by settings
val curseGradleVersion: String by settings
val minecraftVersion: String by settings

rootProject.name = "jehc-$minecraftVersion"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("http://files.minecraftforge.net/maven") }
    }

    resolutionStrategy {
        eachPlugin {
            if(requested.id.id.startsWith("net.minecraftforge.gradle"))
                useModule("net.minecraftforge.gradle:ForgeGradle:$forgeGradleVersion")
            if(requested.id.id.startsWith("com.matthewprenger.cursegradle"))
                useVersion(curseGradleVersion)
        }
    }
}