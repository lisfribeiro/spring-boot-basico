package io.github.lisfribeiro.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/somar/{num1}/{num2}")
    public Double somar(@PathVariable double num1,
                        @PathVariable double num2) {
        return num1 + num2;
    }

    @GetMapping("/subtrair")
    public Double subtrair(@RequestParam(name = "num1") double num1,
                           @RequestParam(name = "num2") double num2) {
        return num1 - num2;
    }
}