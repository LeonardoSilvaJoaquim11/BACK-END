package com.example.fipe.dto;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FipeService {

    private final FipeClient fipeClient;

    public FipeService(FipeClient fipeClient) {
        this.fipeClient = fipeClient;
    }

    public FipeResponse consultarValor(CarroRequest request) {
        try {
            var restClient = fipeClient.getRestClient();

            // 1. Buscar marcas
            var marcas = restClient.get()
                    .uri("/marcas")
                    .retrieve()
                    .body(Map[].class);

            String codigoMarca = null;
            for (Map m : marcas) {
                if (m.get("nome").toString().equalsIgnoreCase(request.getMarca())) {
                    codigoMarca = m.get("codigo").toString();
                    break;
                }
            }
            if (codigoMarca == null) return null;

            // 2. Buscar modelos
            var modelosResponse = restClient.get()
                    .uri("/marcas/{marca}/modelos", codigoMarca)
                    .retrieve()
                    .body(Map.class);

            var modelos = (Object[]) ((Map) modelosResponse).get("modelos");
            String codigoModelo = null;
            for (Object obj : modelos) {
                Map modeloMap = (Map) obj;
                if (modeloMap.get("nome").toString().toLowerCase().contains(request.getModelo().toLowerCase())) {
                    codigoModelo = modeloMap.get("codigo").toString();
                    break;
                }
            }
            if (codigoModelo == null) return null;

            // 3. Buscar anos
            var anos = restClient.get()
                    .uri("/marcas/{marca}/modelos/{modelo}/anos", codigoMarca, codigoModelo)
                    .retrieve()
                    .body(Map[].class);

            String codigoAno = null;
            for (Map a : anos) {
                if (a.get("nome").toString().contains(request.getAno().toString())) {
                    codigoAno = a.get("codigo").toString();
                    break;
                }
            }
            if (codigoAno == null) return null;

            // 4. Buscar valor FIPE
            var fipeData = restClient.get()
                    .uri("/marcas/{marca}/modelos/{modelo}/anos/{ano}", codigoMarca, codigoModelo, codigoAno)
                    .retrieve()
                    .body(Map.class);

            Double valor = Double.parseDouble(fipeData.get("Valor").toString()
                    .replace("R$", "")
                    .replace(".", "")
                    .replace(",", ".")
                    .trim());

            String mes = fipeData.get("MesReferencia").toString();

            return new FipeResponse(valor, mes);

        } catch (Exception e) {
            return null;
        }
    }
}
