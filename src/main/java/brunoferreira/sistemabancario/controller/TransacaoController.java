package brunoferreira.sistemabancario.controller;

import brunoferreira.sistemabancario.model.Transacao;
import brunoferreira.sistemabancario.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransacaoController {
    /*@Autowired
    private TransacaoService transacaoService;

    @PostMapping("/realizarDeposito")
    @ResponseStatus(HttpStatus.OK)
    public Transacao realizarDepositar(@RequestParam Long idConta, @RequestParam Double valor) {
        return transacaoService.realizaDeposito(idConta, valor);
    }

     */
}
