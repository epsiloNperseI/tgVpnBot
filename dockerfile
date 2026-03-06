FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests --no-transfer-progress

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/tgVpnBot-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]