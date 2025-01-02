object Versions {
    const val COROUTINES = "1.7.3"
    const val JUNIT = "5.10.0"
    const val MOCKK = "1.13.8"
    const val SLF4J = "2.0.9" // Logging용
    const val KOTLIN = "1.9.24"
}

object Dependencies {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"

    const val junitApi = "org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT}"
    const val junitEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT}"
    const val mockk = "io.mockk:mockk:${Versions.MOCKK}"

    const val slf4jApi = "org.slf4j:slf4j-api:${Versions.SLF4J}"
}