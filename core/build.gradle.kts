plugins {
    kotlin("jvm")
}

group = "com.kimmandoo.dumpling"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.slf4jApi)
    testImplementation(Dependencies.junitApi)
    testImplementation(Dependencies.junitEngine)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.coroutinesTest)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}