# producto-bricks

# Proyecto de Categorías

Este proyecto es una aplicación Spring Boot que utiliza Java 17, H2 como base de datos en memoria y Gradle como herramienta de construcción. La aplicación incluye un servicio para gestionar categorías, con soporte para cacheo mediante `ConcurrentMapCacheManager`.

## Requisitos

- Java 17
- Gradle

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.3.1
- H2 Database
- Gradle
- Spring Cache (ConcurrentMapCacheManager)

## Consola H2

- http://localhost:8080/h2-console/login.jsp?jsessionid=b7bece69ecb59728e6e5cf3bfd14e228

## Configuración del Proyecto

### Dependencias

El archivo `build.gradle` incluye las siguientes dependencias principales:

```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.3.1'
    id 'io.spring.dependency-management' version '1.1.5'
}

group = 'com.bricks.test'
version = '0.0.1-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

ext {
    set('springCloudVersion', "2023.0.2")
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.cloud:spring-cloud-starter-openfeign'
    implementation 'org.springframework.boot:spring-boot-starter-cache'
    implementation 'org.ehcache:ehcache'

    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    runtimeOnly 'com.h2database:h2'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

// Configuración para habilitar -parameters en el compilador Java
tasks.withType(JavaCompile) {
    options.compilerArgs << '-parameters'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}

tasks.named('test') {
    useJUnitPlatform()
}

