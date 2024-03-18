plugins {
    id("buildlogic.kotlin-springboot-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
