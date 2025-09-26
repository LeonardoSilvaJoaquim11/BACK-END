package com.example.fipe.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    private final FipeService fipeService;

    public FipeController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @PostMapping
    public ResponseEntity<FipeResponse> consultar(@RequestBody CarroRequest request) {
        FipeResponse response = fipeService.consultarValor(request);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
