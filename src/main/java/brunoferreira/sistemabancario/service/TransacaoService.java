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

    //Para fazer um deposito tendo o id da conta
    public Transacao realizarDeposito(Long idConta, Double valor){
        //Busca a conta por seu id
        Optional<Conta> contaOptional = contaRepository.findById(idConta);

        //Se houver conta com o id fornecido é feito o deposito
        if(contaOptional.isPresent()){
            //Obtem a conta por completo
            Conta conta = contaOptional.get();

            //Obtem o saldo atual da conta
            Double saldoAtual = conta.getSaldo();

            //Adiciona o valor do parametro com o valor atual da conta
            Double saldoAdd = saldoAtual + valor;
            conta.setSaldo(saldoAdd);

            contaRepository.save(conta);

            //Cria uma transação e seta os valores
            Transacao transacao = new Transacao();
            transacao.setConta(conta);
            transacao.setValor(valor);
            transacao.setDescricao("Deposito");

            //Adiciona a transação com todos seus dados no banco de dados
            return transacaoRepository.save(transacao);
        }else{
            //Se não houver conta com o id fornecido retorna o erro
            throw new RuntimeException("Conta não encontrada: " + idConta);
        }
    }

    //Para fazer um saque tendo o id da conta
    public Transacao realizarSaque(Long idConta, Double valor){
        //Busca a conta por seu id
        Optional<Conta> contaOptional = contaRepository.findById(idConta);

        //Se o Optinal retornar vazio já dispara o erro e encerra.
        if(contaOptional.isEmpty()){
            throw new RuntimeException("Conta não encontrada: " + idConta);
        }

        //Obtem a conta por completo
        Conta conta = contaOptional.get();

        //Obtem o saldo atual da conta
        Double saldoAtual = conta.getSaldo();

        //Verifica se a conta possui saldo disponivel para saque
        if(saldoAtual <= 0){
            throw  new RuntimeException("Conta não possui saldo para sacar: " + saldoAtual);
        }else{
            //Efetua a operação de saque na conta
            Double saldoDrop = saldoAtual - valor;

            //Preenche o valor do saldo atual apos o saque
            conta.setSaldo(saldoDrop);
            contaRepository.save(conta);

            //Cria uma transação e seta os valores
            Transacao transacao = new Transacao();
            transacao.setConta(conta);
            transacao.setValor(valor);
            transacao.setDescricao("Saque");

            return transacaoRepository.save(transacao);
        }

    }
}
