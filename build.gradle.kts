plugins {
    id("java")
}

group = "io.github.wisniowa2024tc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.10")
}

tasks.test {
    useJUnitPlatform()
}