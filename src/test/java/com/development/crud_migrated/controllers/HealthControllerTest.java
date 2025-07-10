package com.development.crud_migrated.controllers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthControllerTest {

    @Test
    @DisplayName("Deve retornar status OK e mensagem de aplicação saudável")
    void testGetHealth() {
        HealthController controller = new HealthController();
        Map<String, String> result = controller.getHealth();

        assertEquals("OK", result.get("status"));
        assertEquals("Aplicação saudável!", result.get("message"));
        assertEquals(2, result.size());
    }

}
