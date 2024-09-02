package com.services.users.service;

import com.google.gson.JsonParser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CountryValidator implements ConstraintValidator<CountryValidation, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        HttpResponse<String> response;
        String url = "https://country.io/names.json";

        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(
                    url))
                    .GET()
                    .build();
            response = HttpClient
                    .newHttpClient()
                    .send(
                            request,
                            HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body().contains(": \"" + s + "\"");
    }
}