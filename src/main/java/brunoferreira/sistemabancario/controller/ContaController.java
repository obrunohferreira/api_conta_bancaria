package brunoferreira.sistemabancario.controller;

import brunoferreira.sistemabancario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.service.ContaService;

import java.util.List;
import java.util.Optional;

@RestController
public class ContaController {
    //Injetando a classe de serviços
    @Autowired
    private ContaService service;

    //Salva uma nova conta
    @PostMapping("/salvarConta")
    @ResponseStatus(HttpStatus.OK)
    public Conta realizaDeposito(@RequestBody Conta conta){
        return service.salvaConta(conta);
    }

    //Lista todas as contas
    @GetMapping("listarContas")
    @ResponseStatus(HttpStatus.OK)
    public List<Conta> listarContas(){
        return service.listaContas();
    }

    //Retorna conta por ID
    @GetMapping("/listarContaId")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Conta> listarUsuarioId(@RequestParam Long idUsuario){
        return service.listarContaId(idUsuario);
    }

}
