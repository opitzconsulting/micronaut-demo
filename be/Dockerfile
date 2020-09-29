FROM openjdk:11-jdk-slim as builder

RUN mkdir /build
COPY . /build
WORKDIR /build
RUN ./gradlew assemble

FROM openjdk:11-jdk-slim

COPY --from=builder /build/build/libs/be-0.1-all.jar /be-0.1-all.jar
#COPY --from=builder /docker/ be-0.1-all.jar
CMD ["java", "-jar","be-0.1-all.jar"]
#CMD java -jar /app.jar