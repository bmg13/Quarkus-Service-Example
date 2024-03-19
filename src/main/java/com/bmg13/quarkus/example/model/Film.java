package com.bmg13.quarkus.example.model;

import java.util.UUID;

public record Film(UUID id, String title, String author, int yearOfPublication) {}
