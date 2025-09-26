package com.example.phone;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class PhoneValidationService {

    private final RestClient restClient;
    private final String accessKey = "SUA_CHAVE_AQUI"; // coloque a apiKey obtida no numverify

    public PhoneValidationService(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://apilayer.net/api").build();
    }

    public Map<String, Object> validateNumber(String number) {
        // Faz a requisição GET para a API numverify
        Map<String, Object> response = restClient.get()
                .uri("/validate?access_key={key}&number={num}", accessKey, number)
                .retrieve()
                .body(Map.class);

        return createCreativeResponse(response);
    }

    private Map<String, Object> createCreativeResponse(Map<String, Object> orig) {
        boolean valid = Boolean.TRUE.equals(orig.get("valid"));
        String international = (String) orig.get("international_format");
        String country = (String) orig.get("country_name");
        String carrier = (String) orig.get("carrier");
        String lineType = (String) orig.get("line_type");

        if (!valid) {
            return Map.of(
                    "sua_resposta_criativa", "Esse número parece ser inválido 📵"
            );
        } else {
            String message = String.format(
                    "Número %s é válido! Local: %s, Operadora: %s, Tipo: %s",
                    international, country, carrier, lineType
            );
            return Map.of(
                    "sua_resposta_criativa", message
            );
        }
    }
}
