package org.ismail.Tricol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FournisseurController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}
