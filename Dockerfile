FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app

COPY build.gradle settings.gradle gradle/ ./
RUN chmod +x gradlew
RUN ./gradlew build --no-daemon -x test

COPY . .
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

RUN useradd -m -s /usr/sbin/nologin appuser
USER appuser

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
