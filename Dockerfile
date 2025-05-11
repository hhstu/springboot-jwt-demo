FROM maven:3.9.6-eclipse-temurin-17-focal as builder
ADD . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17.0.11_9-jdk-ubi9-minimal
COPY --from=builder  target/demo.jar demo.jar
CMD ["java","-jar","demo.jar"]