pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BirdsWatching"
include(":app")
include(":core:common")
include(":core:data")
include(":core:network")
include(":core:model")
include(":core:ui")
include(":core:designsystem")
include(":feature:home")
include(":feature:detail")
