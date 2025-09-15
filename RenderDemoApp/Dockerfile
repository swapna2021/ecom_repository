# ---------- Build stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /build
# copy only pom first for caching (optional)
COPY RenderDemoApp/pom.xml .
RUN mvn -q -e -B -DskipTests dependency:go-offline
# now copy sources
COPY RenderDemoApp/src ./src
# build jar
RUN mvn -q -e -B -DskipTests package

# ---------- Run stage ----------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# copy the jar built in previous stage
COPY --from=build /build/target/*.jar app.jar

# Render provides PORT env; Spring Boot reads it (we’ll wire it in application.properties)
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]