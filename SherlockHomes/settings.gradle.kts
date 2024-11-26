rootProject.name = "homes"

include(
    "homes-apt",
    "homes-mono",
    "homes-user",
    "homes-map",
    "homes-db",
    "homes-ai",
    "homes-batch",
    "homes-eureka",
    "homes-gateway",
    
    "storage",
    "storage:db-jpa",
    "response-model",
    "logging",
    "swagger",
)

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
            }
        }
    }
}