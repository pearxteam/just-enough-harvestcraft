import net.minecraftforge.gradle.common.BaseExtension
import net.minecraftforge.gradle.user.UserBaseExtension

plugins {
    id("net.minecraftforge.gradle.forge")
}

val modVersion: String by project
val modDescription: String by project
val modDependencies: String by project
val modAcceptedMcVersions: String by project

val forgeVersion: String by project
val minecraftVersion: String by project
val mcpMappingsVersion: String by project

val jeiVersion: String by project
val jeiMcVersion: String by project

val jdkVersion: String by project

version = modVersion
group = "ru.pearx.jehc"
description = modDescription

configure<BasePluginConvention> {
    archivesBaseName = "jehc-$minecraftVersion"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.toVersion(jdkVersion)
}

configure<UserBaseExtension> {
    version = "$minecraftVersion-$forgeVersion"
    runDir = "run"
    mappings = mcpMappingsVersion
    replace("VERSION = \"\"", "VERSION = \"$modVersion\"")
    replace("DESCRIPTION = \"\"", "DESCRIPTION = \"$modDescription\"")
    replace("ACCEPTED_MINECRAFT_VERSIONS = \"\"", "ACCEPTED_MINECRAFT_VERSIONS = \"$modAcceptedMcVersions\"")
    replace("DEPENDENCIES = \"\"", "DEPENDENCIES = \"$modDependencies\"")
    replaceIn("JEHC.java")
}

repositories {
    maven { url = uri("http://dvs1.progwml6.com/files/maven") }
}

dependencies {
    "deobfCompile"("mezz.jei:jei_$jeiMcVersion:$jeiVersion:api")
    "runtime"("mezz.jei:jei_$jeiMcVersion:$jeiVersion")
}