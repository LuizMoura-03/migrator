package com.development.crud_migrated.services;

import com.development.crud_migrated.config.StackSpotAgentConfig;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class StackSpotAgentServiceImpl implements StackSpotAgentService {


    private static final Logger logger = LoggerFactory.getLogger(StackSpotAgentServiceImpl.class);
    private final StackSpotAgentConfig config;

    public StackSpotAgentServiceImpl(StackSpotAgentConfig config) {
        this.config = config;
    }

    @Override
    public String getAccessToken() throws Exception {
        String url = "https://idm.stackspot.com/" + config.getRealm() + "/oidc/oauth/token";

        // Monta o corpo da requisição com os parâmetros de token
        String body = "grant_type=client_credentials"
                + "&client_id=" + config.getClientId()
                + "&client_secret=" + config.getClientSecret();

        logger.info("Obtendo token de acesso da URL: {}", url);
        logger.debug("Payload de obtenção de token: {}", body);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        logger.info("Resposta de token obtida, status: {}", response.statusCode());
        logger.debug("Resposta de token: {}", response.body());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao obter token: " + response.body());
        }

        JSONObject json = new JSONObject(response.body());
        return json.getString("access_token");
    }

    @Override
    public String perguntarAoAgente(String pergunta) throws Exception {
        String token = getAccessToken();
        logger.info("Token obtido com sucesso.");

        // Monta o payload de acordo com o que o agente espera
        JSONObject payload = new JSONObject();
        payload.put("streaming", false);
        payload.put("user_prompt", pergunta);
        payload.put("stackspot_knowledge", true);
        payload.put("return_ks_in_response", true);

        logger.info("Enviando pergunta para o agente: {}", pergunta);
        logger.debug("Payload enviado: {}", payload.toString());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(config.getEndpoint()))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        logger.info("Resposta do agente, status: {}", response.statusCode());
        logger.debug("Resposta do agente: {}", response.body());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao consultar agente: " + response.body());
        }

        return response.body();
    }
}
