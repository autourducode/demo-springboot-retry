package io.autourducode.appa;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author autourducode
 */
@Service
public class DemoService {
    private final RestTemplate restTemplate;

    public DemoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retryable(maxAttempts = 4, backoff = @Backoff(4000L))
    public String serviceAppB() {
        System.out.println("======== Ressayer ==========");
        return restTemplate.getForObject("http://localhost:8081/app-b/service", String.class);
    }

    @Recover
    public String info() {
        System.out.println("====== Pas de reponse ==========");
        return "APP-B non disponible!";
    }
}
