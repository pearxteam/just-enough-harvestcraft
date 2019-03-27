import com.matthewprenger.cursegradle.CurseExtension
import com.matthewprenger.cursegradle.CurseProject
import net.minecraftforge.gradle.user.UserBaseExtension

plugins {
    id("net.minecraftforge.gradle.forge")
    id("com.matthewprenger.cursegradle")
    `maven-publish`
}

val modVersion: String by project
val modReleaseType: String by project
val modDescription: String by project
val modChangelog: String by project
val modDependencies: String by project
val modAcceptedMcVersions: String by project

val forgeVersion: String by project
val minecraftVersion: String by project
val mcpMappingsVersion: String by project

val jeiVersion: String by project
val jeiMcVersion: String by project

val jdkVersion: String by project

val curseforgeProjectId: String by project

val pearxRepoUsername: String? by project
val pearxRepoPassword: String? by project
val curseforgeApiKey: String? by project

version = modVersion
group = "ru.pearx.jehc"
description = modDescription

java {
    sourceCompatibility = JavaVersion.toVersion(jdkVersion)
}

repositories {
    maven { url = uri("http://dvs1.progwml6.com/files/maven") }
}

dependencies {
    "deobfCompile"("mezz.jei:jei_$jeiMcVersion:$jeiVersion:api")
    "runtime"("mezz.jei:jei_$jeiMcVersion:$jeiVersion")
}

configure<UserBaseExtension> {
    version = "$minecraftVersion-$forgeVersion"
    runDir = "run"
    mappings = mcpMappingsVersion
    replace("VERSION = \"\"", "VERSION = \"$modVersion\"")
    replace("DESCRIPTION = \"\"", "DESCRIPTION = \"$modDescription\"")
    replace("ACCEPTED_MINECRAFT_VERSIONS = \"\"", "ACCEPTED_MINECRAFT_VERSIONS = \"$modAcceptedMcVersions\"")
    replace("DEPENDENCIES = \"\"", "DEPENDENCIES = \"$modDependencies\"")
    replaceIn("Jehc.java")
}

configure<CurseExtension> {
    apiKey = curseforgeApiKey ?: "0"
    project(closureOf<CurseProject> {
        id = curseforgeProjectId
        releaseType = modReleaseType
        changelog = modChangelog
    })
}

publishing {
    repositories {
        fun AuthenticationSupported.pearxCredentials() {
            credentials {
                username = pearxRepoUsername
                password = pearxRepoPassword
            }
        }
        maven {
            pearxCredentials()
            name = "develop"
            url = uri("https://repo.pearx.ru/maven2/develop/")
        }
        maven {
            pearxCredentials()
            name = "release"
            url = uri("https://repo.pearx.ru/maven2/release/")
        }
    }

    publications {
        register<MavenPublication>("maven") {
            artifact(tasks.getByName<Jar>("jar"))
        }
    }
}

tasks {
    register("publishDevelop") {
        group = "publishing"
        dependsOn(withType<PublishToMavenRepository>().matching { it.repository == publishing.repositories["develop"] })
    }
    register("publishRelease") {
        group = "publishing"
        dependsOn(withType<PublishToMavenRepository>().matching { it.repository == publishing.repositories["release"] })
        dependsOn(named("curseforge"))
    }
}