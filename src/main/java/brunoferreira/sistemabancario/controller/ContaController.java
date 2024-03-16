package brunoferreira.sistemabancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.service.ContaService;

import java.util.List;

@RestController
public class ContaController {
    @Autowired
    private ContaService service;

    @PostMapping("/salvarConta")
    @ResponseStatus(HttpStatus.OK)
    public Conta realizaDeposito(@RequestBody Conta conta){
        return service.salvaConta(conta);
    }

    @GetMapping("listarContas")
    @ResponseStatus(HttpStatus.OK)
    public List<Conta> listarContas(){
        return service.listaContas();
    }

}
