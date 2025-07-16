package com.development.crud_migrated.services;

public interface StackSpotAgentService {
    String getAccessToken() throws Exception;
    String perguntarAoAgente(String pergunta) throws Exception;
}
