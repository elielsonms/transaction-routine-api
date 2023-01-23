plugins {
	java
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.elielsonms"
version = "0.0.2-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

val mapStrutsVersion = "1.5.3.Final"
val mockitoVersion = "3.9.0"

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")


	implementation("org.mapstruct:mapstruct:$mapStrutsVersion")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testImplementation("org.mockito:mockito-core:$mockitoVersion")

	runtimeOnly("mysql:mysql-connector-java")
	runtimeOnly("com.h2database:h2")

	annotationProcessor("org.mapstruct:mapstruct-processor:${mapStrutsVersion}")
}

tasks.withType<Test> {
	useJUnitPlatform()
}