plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.testng:testng:7.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("io.appium:java-client:9.4.0")
}

tasks.test {
    useJUnitPlatform()
    useTestNG()
}
