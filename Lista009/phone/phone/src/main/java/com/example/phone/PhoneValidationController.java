package com.example.phone;

import com.example.phone.PhoneValidationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/telefone")
public class PhoneValidationController {

    private final PhoneValidationService service;

    public PhoneValidationController(PhoneValidationService service) {
        this.service = service;
    }

    @GetMapping("/validar/{numero}")
    public Map<String, Object> validar(@PathVariable String numero) {
        return service.validateNumber(numero);
    }
}
