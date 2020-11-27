FROM openjdk:11-jdk-slim as builder

RUN mkdir /build
COPY . /build
WORKDIR /build
#use the following line under windows as "CMD ./gradlew --no-daemon assemble"
#under linux operating system as "RUN ./gradlew --no-daemon assemble"
RUN ./gradlew --no-daemon assemble

FROM openjdk:11-jdk-slim
COPY --from=builder /build/build/libs/be-0.1-all.jar /be-0.1-all.jar
RUN apt update && apt install -y netcat
COPY ./docker/wait_for /usr/bin/wait_for
CMD ["java", "-jar","be-0.1-all.jar"]
