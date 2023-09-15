import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven {
		url = uri("https://packages.confluent.io/maven")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:3.1.3")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-web:3.1.3")
	implementation("org.springframework.boot:spring-boot-starter-actuator:3.1.3")
	implementation("org.zalando:logbook-spring-boot-starter:3.3.0")
	implementation("org.springframework.kafka:spring-kafka:3.0.11")
	implementation("io.confluent:kafka-schema-registry-client:7.1.1")
	implementation("com.github.avro-kotlin.avro4k:avro4k-core:1.6.0")
	implementation("com.github.thake.avro4k:avro4k-kafka-serializer:0.13.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	jvmTarget = "17"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
	jvmTarget = "17"
}
