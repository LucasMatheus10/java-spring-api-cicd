FROM eclipse-temurin:21jdk-jammy as builder

WORKDIR /app

COPY pom.xml .
COPY .mvn ./.mvn
COPY mvnw .

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw package -DskipTests  

FROM eclipse-temurin:21jre-jammy

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]