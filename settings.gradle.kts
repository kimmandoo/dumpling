plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "dumpling"
include("core")
include("protocol")
include("security")
include("test")
include("sample")
