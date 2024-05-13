plugins {
    `java-library`
    `maven-publish`
}

group = "com.xorltd"
version = "0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
}

publishing {
    publications {

    }
}

dependencies {
    testImplementation("org.slf4j:slf4j-simple:2.0.13")
    api("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

task("sourcesJar", Jar::class) {
   from(sourceSets.main.get().allJava)
}

publishing {
    publications.create<MavenPublication>("maven") {
        groupId = "io.xorltd.hue"
        artifactId = "hue4j"
        version = version

        from(components["java"])
    }
}

tasks.test {
    useJUnitPlatform()
}