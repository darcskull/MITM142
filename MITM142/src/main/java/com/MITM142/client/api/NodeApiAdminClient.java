package com.MITM142.client.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class NodeApiAdminClient {
    private final HttpClient httpClient;
    private final String baseUrl;
    private final ConcurrentHashMap<String, String> headers = new ConcurrentHashMap<>();

    public NodeApiAdminClient(String baseUrl) {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        this.baseUrl = baseUrl;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public String issueTokenBySecret(String secret, String payload) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/token/issue"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"secret\":\"" + secret + "\", \"payload\":\"" + payload + "\"}"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to issue token: " + response.body());
        }
        return response.body(); // Assuming the response body contains the token as plain text or JSON.
    }

    public String refreshToken() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/refresh-token"))
                .header("Content-Type", "application/json")
                .headers(headers.entrySet().stream().flatMap(e -> Stream.of(e.getKey(), e.getValue())).toArray(String[]::new))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to refresh token: " + response.body());
        }
        return response.body(); // Assuming the response body contains the new token.
    }
}