package com.development.crud_migrated.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")  // Mapeia o endpoint GET /health.
    public Map<String, String> getHealth() {
        // Retorna um Map que será convertido automaticamente para JSON.
        return Map.of(
                "status", "OK",
                "message", "Aplicação saudável!"
        );
    }

}
