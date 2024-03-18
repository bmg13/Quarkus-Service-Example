#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=com.bmg13.quarkus.example \
        -DprojectArtifactId=rest-film \
        -DclassName="com.bmg13.quarkus.example.FilmResource" \
        -Dpath="/api/films" \
        -Dextensions="resteasy-jsonb"