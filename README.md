# Quarkus Service Example

## Overview

The aim of this project is to have a barebone example of a project done with Quarkus as a java toolkit to start its understanding.
It is based on udemy course (see references) and the current high level architecture is
![Architecture](https://github.com/bmg13/Quarkus-Service-Example/assets/18561736/9acdf130-0b5f-40e2-9e35-17562f81cdfd)

This service contains a simple controller, following REST and responding with dummy data. Potential additions over time may be expected in this project.



## Bootstrap

First time, having the following shell script

```
#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=com.bmg13.quarkus.example \
        -DprojectArtifactId=rest-film \
        -DclassName="com.bmg13.quarkus.example.controller.FilmController" \
        -Dpath="/api/films" \
        -Dextensions="resteasy-jsonb"
```

bootstrap it

```sh ./bootstrap.sh```
that (after all the downloads) should print something similar to
![Bootstrap Terminal](https://github.com/bmg13/Quarkus-Service-Example/assets/18561736/bedb197d-bea4-4394-b751-490ce86d22c0)

> Note: In order to use CDI with Quarkus, the better usage would be using ARC
> ```
> <dependency>
>    <groupId>io.quarkus</groupId>
>    <artifactId>quarkus-arc</artifactId>
> </dependency>
>```

## Run

To run the application in dev mode (only mode with Hot Reload) simply run

```mvn quarkus:dev```

this starts Quarkus at ***localhost:8080***

> to use the Dev UI (dev mode only) http://localhost:8080/q/dev/.
![Dev UI](https://github.com/bmg13/Quarkus-Service-Example/assets/18561736/45abc27b-6de9-48e7-9e75-8ab1a890cc3b)



### Package (and run jar)

to package, simply run
```
mvn package -DskipTests
```

and then, to run it, use the specific jar create by quarkus
```
java -jar target/quarkus-app/quarkus-run.jar
```

## Containerization

Creating the image is simple, keeping in mind that the bootstrap above already created a Dockerfile for the jvm. If aimed at native image, consider the Dockerfile.native.

To add the docker extension to quarkus, run
```
 mvn quarkus:add-extension -Dextensions="container-image-docker"
```

the following dependency will be added automatically
```
<dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-container-image-docker</artifactId>
    </dependency>
```

Once having the docker running locally, run
```
 mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=jar -DskipTests
```
ensure image is created

![docker list](https://github.com/bmg13/Quarkus-Service-Example/assets/18561736/26f44c6e-36fe-4885-b212-5c4640156aae)

finally, run with docker
```
 docker run -i --rm -p 8080:8080 goncalomonteiro/quarkus.example:1.0.0-SNAPSHOT
```
> You need to explicitly specify the tag. You can also rename the tag, see Docker documentation

## Testing

Quarkus testing uses JUNIT underneath, wiht v5 being the current in use.
To annotate a class test just add the ***@QuarkusTest*** annotation.
Example testing
```
@QuarkusTest
public class FilmControllerTest {

    @Test
    void shouldReturnFilmCount() {
        given()
                .header(ACCEPT, MediaType.APPLICATION_JSON)
        .when()
                .get("/api/films")
        .then()
                .statusCode(200)
                .body("size()", is(3));
    }
```

Finally run
```
mvn test
```
to run the tests.

## Profiles

As expected, Quarkus enables profiling and even eases the definition of a property value based on the profile, as example (in application.properties)

```
%dev.film.language=Spanish
%prod.film.language=English
```

## References

### Context
- https://www.udemy.com/course/quarkus-starting-with-quarkus/
- https://code.quarkus.io
- https://github.com/quarkiverse

### Setup
- https://github.com/graalvm/homebrew-tap
- https://www.graalvm.org/latest/docs/getting-started/macos/
- https://github.com/agoncal/agoncal-course-quarkus-starting/blob/master/bootstrap.sh
