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

    //Salva uma nova conta
    public Conta salvarConta(@RequestBody Conta conta){;
       return contaRepository.save(conta);
    }

    //Atualiza tipo da conta pelo id
    public Conta atualizarConta(Long idConta, Conta contaAtualizada) {
        //Verifica se o usuário existe no banco de dados
        Optional<Conta> contaOptional = contaRepository.findById(idConta);
        if (contaOptional.isEmpty()) {
            throw new RuntimeException("Conta não encontrada: " + idConta);
        }

        //Obter o usuário existente do Optional
        Conta contaExistente = contaOptional.get();

        //Atualizar os campos do usuário existente com os valores do usuário atualizado
        contaExistente.setTipo(contaAtualizada.getTipo());

        return contaRepository.save(contaExistente);
    }

    //Apaga uma conta pelo id
    public void apagarConta(Long idConta){
        //Verifica se o usuário existe no banco de dados
        Optional<Conta> contaOptional = contaRepository.findById(idConta);
        if (contaOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idConta);
        }

        contaRepository.deleteById(idConta);

    }

    public List<Transacao> extrato(Long idConta){
        return transacaoRepository.extrato(idConta);
    }

    //Lista todas contas
    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    //Lista conta por id
    public Optional<Conta> listarContaId(Long idConta){
        return contaRepository.findById(idConta);
    }

}
