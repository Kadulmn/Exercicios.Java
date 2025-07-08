/*
Testando API e suas funcionalidades
 */
package com.kadu.minha_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteAPI {

    @GetMapping("/hello")
    public String hello() {
        return "Teste de API ";
    }
}
