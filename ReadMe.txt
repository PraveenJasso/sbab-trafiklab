=====================
## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `route.com.kc.RouteApplication` class from your IDE.

## Deploying the application

The way to deploy the application is

* Clone or pull the latest code
* Run the maven clean command - mvn clean
* Run the maven intall command - mvn install
* copy the route-0.0.1-SNAPSHOT.jar file to some other location

## Run the application

Application will run on the 8080 port as default.

To run the application. Use the following command,

java -jar <JAR COPIED LOCATION>route-0.0.1-SNAPSHOT.jar


## Sample APIs

http://localhost:8080/route/v1/routes/toproutes?model=StopArea
http://localhost:8080/route/v1/routes?model=StopArea