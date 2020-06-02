@file:Suppress("PropertyName")

val junit_version: String by project
val kluent_version: String by project

plugins {
    java
    kotlin("jvm") version "1.3.72"
    idea
    eclipse
}

group = "me.motyim"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter:$junit_version")
    testImplementation("org.amshove.kluent:kluent:$kluent_version")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}