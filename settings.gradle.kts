rootProject.name = "jehc"

val forgeGradleVersion: String by settings

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("http://files.minecraftforge.net/maven") }
    }

    resolutionStrategy {
        eachPlugin {
            if(requested.id.id.startsWith("net.minecraftforge.gradle"))
                useModule("net.minecraftforge.gradle:ForgeGradle:$forgeGradleVersion")
        }
    }
}