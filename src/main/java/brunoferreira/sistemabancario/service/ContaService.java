package brunoferreira.sistemabancario.service;

import brunoferreira.sistemabancario.model.Usuario;
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
    private ContaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Salva uma nova conta
    public Conta salvarConta(@RequestBody Conta conta){;
       return repository.save(conta);
    }

    //Atualiza tipo da conta pelo id
    public Conta atualizarConta(Long idConta, Conta contaAtualizada) {
        //Verifica se o usuário existe no banco de dados
        Optional<Conta> contaOptional = repository.findById(idConta);
        if (contaOptional.isEmpty()) {
            throw new RuntimeException("Conta não encontrada: " + idConta);
        }

        //Obter o usuário existente do Optional
        Conta contaExistente = contaOptional.get();

        //Atualizar os campos do usuário existente com os valores do usuário atualizado
        contaExistente.setTipo(contaAtualizada.getTipo());

        return repository.save(contaExistente);
    }

    //Apaga uma conta pelo id
    public void apagarConta(Long idConta){
        //Verifica se o usuário existe no banco de dados
        Optional<Conta> contaOptional = repository.findById(idConta);
        if (contaOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idConta);
        }

        repository.deleteById(idConta);

    }

    //Lista todas contas
    public List<Conta> listarContas(){
        return repository.findAll();
    }

    //Lista conta por id
    public Optional<Conta> listarContaId(Long idConta){
        return repository.findById(idConta);
    }

}
