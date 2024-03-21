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
    public Conta salvarConta(@RequestBody Conta conta){
        return service.salvarConta(conta);
    }

    //Atualiza uma conta
    @PutMapping("/atualizarConta/{idConta}")
    @ResponseStatus(HttpStatus.OK)
    public Conta atualizarConta(@PathVariable Long idConta,
                                @RequestBody Conta conta){
        return service.atualizarConta(idConta, conta);
    }

    //Apaga uma conta pelo id
    @DeleteMapping("/apagarContaId")
    @ResponseStatus(HttpStatus.OK)
    public void apagarConta(@RequestParam Long idConta){
        service.apagarConta(idConta);
    }

    //Lista todas contas
    @GetMapping("/listarContas")
    @ResponseStatus(HttpStatus.OK)
    public List<Conta> listarConta(){
        return service.listarContas();
    }

    //Lista conta pelo ID
    @GetMapping("/listarContaId")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Conta> listarContaId(@RequestParam Long idConta){
        return service.listarContaId(idConta);
    }

}
