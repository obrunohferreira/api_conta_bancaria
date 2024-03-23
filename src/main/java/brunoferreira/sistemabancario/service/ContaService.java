package brunoferreira.sistemabancario.service;

import brunoferreira.sistemabancario.model.Transacao;
import brunoferreira.sistemabancario.repository.TransacaoRepository;
import brunoferreira.sistemabancario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.repository.ContaRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    //Para salvar uma conta
    public Conta salvarConta(@RequestBody Conta conta){;
       return contaRepository.save(conta);
    }

    //Para atualizar tipo da conta por seu id
    public Conta atualizarConta(Long idConta, Conta contaAtualizada) {
        //Verifica se o usuário existe no banco de dados
        Optional<Conta> contaOptional = contaRepository.findById(idConta);
        if (contaOptional.isEmpty()) {
            throw new RuntimeException("Conta não encontrada: " + idConta);
        }

        //Obtem a conta existente do Optional
        Conta contaExistente = contaOptional.get();

        //Atualiza o campo de tipo da conta existente
        contaExistente.setTipo(contaAtualizada.getTipo());

        return contaRepository.save(contaExistente);
    }

    //Para apagar uma conta por seu id
    public void apagarConta(Long idConta){
        //Verifica se a conta existe no banco de dados
        Optional<Conta> contaOptional = contaRepository.findById(idConta);
        if (contaOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idConta);
        }

        contaRepository.deleteById(idConta);

    }

    //Para ter um extrato de todas as transaçoes pelo id da conta
    public List<Transacao> extrato(Long idConta){
        return transacaoRepository.extrato(idConta);
    }

    //Para listar todas as contas no banco de dados
    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    //Para listar uma conta por seu id
    public Optional<Conta> listarContaId(Long idConta){
        return contaRepository.findById(idConta);
    }

}
