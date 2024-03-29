package brunoferreira.sistemabancario.controller;

import brunoferreira.sistemabancario.model.Transacao;
import brunoferreira.sistemabancario.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    //Faz a transação de deposito
    @PostMapping("/realizarDeposito")
    @ResponseStatus(HttpStatus.OK)
    public Transacao realizarDepositar(@RequestParam Long idConta,
                                       @RequestParam Double valor) {
        return transacaoService.realizarDeposito(idConta, valor);
    }

    //Faz a transação de saque
    @PostMapping("/realizarSaque")
    @ResponseStatus(HttpStatus.OK)
    public Transacao realizarSaque(@RequestParam Long idConta,
                                   @RequestParam Double valor){
        return transacaoService.realizarSaque(idConta, valor);
    }
}
