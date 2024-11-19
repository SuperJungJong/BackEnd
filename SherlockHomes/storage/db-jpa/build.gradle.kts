allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("mysql:mysql-connector-java:8.0.33")
}