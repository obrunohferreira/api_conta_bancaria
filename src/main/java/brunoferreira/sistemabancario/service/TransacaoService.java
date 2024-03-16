package brunoferreira.sistemabancario.service;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.model.Transacao;
import brunoferreira.sistemabancario.repository.ContaRepository;
import brunoferreira.sistemabancario.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Transacao realizaDeposito(Long idConta, Double valor){
        Optional<Conta> optionalConta = contaRepository.findById(idConta);

        if(optionalConta.isPresent()){
            Conta conta = optionalConta.get();
            Double saldoAtual = conta.getSaldo();
            Double saldoAdd = saldoAtual + valor;

            conta.setSaldo(saldoAdd);
            contaRepository.save(conta);

            Transacao transacao = new Transacao();
            transacao.setConta(conta);
            transacao.setValor(valor);

            return transacaoRepository.save(transacao);
        }else{
            throw new RuntimeException("Conta não encontrada" + idConta);
        }
    }
}
