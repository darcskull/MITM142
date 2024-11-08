package com.MITM142.controller;

import com.MITM142.client.ApiClient;
import com.MITM142.client.api.NodeApiAdminClient;
import com.MITM142.client.api.KeysApi;
import com.MITM142.client.model.SetKeyParams;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/test")
    public ResponseEntity<Void> login(HttpSession session) {
        try {
            NodeApiAdminClient nodeApiAdminClient = new NodeApiAdminClient("https://demo.s-3.team/api/v1");
            String jwtToken = nodeApiAdminClient.issueTokenBySecret("x-secret", "Idyr0QAxkeyvpobZTT5NpNGmovFWlqtUFycW7oP44dE36FM83Bsg3mTckhHoh7IWos+/WIvWiJ6kYwZdTsXgLA==");
            ApiClient apiClient = new ApiClient();
            apiClient.addDefaultHeader("x-token", jwtToken);

            KeysApi keysApi = new KeysApi(apiClient);

            // Стартиране на автоматично подновяване на токена на всеки 10 секунди
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {
                try {
                    String newToken = nodeApiAdminClient.refreshToken();
                    apiClient.addDefaultHeader("x-token", newToken); // Обновяване на x-token хедъра
                } catch (Exception e) {
                    System.err.println("Грешка при подновяване на токена: " + e.getMessage());
                    scheduler.shutdown();
                }
            }, 0, 10, TimeUnit.SECONDS);
            SetKeyParams setKeyParams = new SetKeyParams();
            setKeyParams.setKey("test-project");
            setKeyParams.setTable("test-table");
            setKeyParams.setValue("test-value");
            String xSecret = "Idyr0QAxkeyvpobZTT5NpNGmovFWlqtUFycW7oP44dE36FM83Bsg3mTckhHoh7IWos+/WIvWiJ6kYwZdTsXgLA==";
            String keys = keysApi.setKey(setKeyParams, "app", xSecret, jwtToken);
            System.out.println(keys);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }

}
