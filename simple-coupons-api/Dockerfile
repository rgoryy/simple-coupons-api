FROM gradle:8.6.0-jdk17 AS builder

WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src src

RUN gradle build

FROM openjdk:17

COPY --from=builder /app/build/libs/coupons.jar /coupons.jar

CMD ["java", "-jar", "/coupons.jar"]