pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net")
        maven("https://repo.essential.gg/repository/maven-public")
    }
}

val modName: String by settings
rootProject.name = modName
