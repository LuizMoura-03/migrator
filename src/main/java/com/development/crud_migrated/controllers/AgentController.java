package com.development.crud_migrated.controllers;

import com.development.crud_migrated.dtos.PerguntaDTO;
import com.development.crud_migrated.services.StackSpotAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private StackSpotAgentService agentService;

    @PostMapping("/perguntar-agente")
    public ResponseEntity<String> perguntarAoAgente(@RequestBody PerguntaDTO dto) {
        try {
            System.out.println("DTO recebido: " + dto.getPergunta());
            String resposta = agentService.perguntarAoAgente(dto.getPergunta());
            return ResponseEntity.ok(resposta);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao consultar agente: " + e.getMessage());
        }

    }

}
