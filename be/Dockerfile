FROM openjdk:11-jdk-slim as builder

RUN mkdir /build
COPY . /build
WORKDIR /build
CMD ./gradlew assemble

FROM openjdk:11-jdk-slim
COPY --from=builder /build/build/libs/be-0.1-all.jar /be-0.1-all.jar
RUN apt update && apt install -y netcat
#COPY ./docker/wait_for /app.jar
CMD ["java", "-jar","be-0.1-all.jar"]