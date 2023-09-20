package com.example.restservice.records;

import java.util.Objects;

public record Greeting(long id, String content) {
    public Greeting {
        Objects.requireNonNull(content);
        if (content.equals("World")) {
            try {
                throw new Exception("NOT VALID!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
