package com.development.crud_migrated.services;

import com.development.crud_migrated.config.StackSpotAgentConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class StackSpotAgentServiceImpl implements StackSpotAgentService{

    private StackSpotAgentConfig config;

    @Autowired
    public StackSpotAgentServiceImpl(StackSpotAgentConfig config) {
        this.config = config;
    }

    @Override
    public String getAccessToken() throws Exception {
        String url = "https://idm.stackspot.com/" + config.getRealm() + "/oidc/oauth/token";
        String body = "grant_type=client_credentials"
                + "&client_id=" + config.getClientId()
                + "&client_secret="
                + config.getClientSecret();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        return json.getString("access_token");
    }

    @Override
    public String perguntarAoAgente(String pergunta) throws Exception {
        String token = getAccessToken();
        JSONObject body = new JSONObject();
        body.put("prompt", pergunta);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(config.getEndpoint()))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send((java.net.http.HttpRequest) request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
