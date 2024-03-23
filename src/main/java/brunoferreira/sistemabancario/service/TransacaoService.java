package brunoferreira.sistemabancario.service;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.model.Transacao;
import brunoferreira.sistemabancario.repository.ContaRepository;
import brunoferreira.sistemabancario.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    //Para fazer um deposito
    public Transacao realizarDeposito(Long idConta, Double valor){
        Optional<Conta> contaOptional = contaRepository.findById(idConta);

        if(contaOptional.isPresent()){
            Conta conta = contaOptional.get();
            Double saldoAtual = conta.getSaldo();
            Double saldoAdd = saldoAtual + valor;

            conta.setSaldo(saldoAdd);
            contaRepository.save(conta);

            Transacao transacao = new Transacao();
            transacao.setConta(conta);
            transacao.setValor(valor);
            transacao.setDescricao("Deposito");

            return transacaoRepository.save(transacao);
        }else{
            throw new RuntimeException("Conta não encontrada: " + idConta);
        }
    }

    //Para fazer um saque
    public Transacao realizarSaque(Long idConta, Double valor){
        Optional<Conta> contaOptional = contaRepository.findById(idConta);

        if(contaOptional.isEmpty()){
            throw new RuntimeException("Conta não encontrada: " + idConta);
        }

        Conta conta = contaOptional.get();
        Double saldoAtual = conta.getSaldo();
        if(saldoAtual <= 0){
            throw  new RuntimeException("Conta não possui saldo para sacar: " + saldoAtual);
        }else{
            Double saldoDrop = saldoAtual - valor;

            conta.setSaldo(saldoDrop);
            contaRepository.save(conta);

            Transacao transacao = new Transacao();
            transacao.setConta(conta);
            transacao.setValor(valor);
            transacao.setDescricao("Saque");

            return transacaoRepository.save(transacao);
        }

    }
}
