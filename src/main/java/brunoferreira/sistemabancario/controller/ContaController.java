package brunoferreira.sistemabancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.service.ContaService;

@RestController
public class ContaController {
    @Autowired
    private ContaService service;

    @PostMapping("/salvarConta")
    @ResponseStatus(HttpStatus.OK)
    public Conta realizaDeposito(@RequestBody Conta conta){
        return service.salvaConta(conta);
    }

}
