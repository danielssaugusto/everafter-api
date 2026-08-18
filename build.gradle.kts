plugins {
    java
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.hibernate.orm") version "8.0.0.Beta1"
}

group = "br.com.tacheon"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val testAgent = configurations.create("testAgent") {
    isTransitive = false
}

dependencies {
    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // Testes
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("com.h2database:h2:1.3.148")

    // ByteBuddy Agent (o verdadeiro agente utilizado pelo Mockito)
    testAgent("net.bytebuddy:byte-buddy-agent:1.14.12")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs(
        "-javaagent:${testAgent.singleFile}",
        "-Xshare:off"
    )
}