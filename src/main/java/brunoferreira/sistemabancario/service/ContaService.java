package brunoferreira.sistemabancario.service;

import brunoferreira.sistemabancario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.repository.ContaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository repository;

    //Salva uma nova conta
    public Conta salvaConta(Conta conta){
        return repository.save(conta);
    }

    //Lista todas as contas
    public List<Conta>listaContas(){
        return repository.findAll();
    }

    //Lista conta pelo ID
    public Optional<Conta> listarContaId(Long idUsuario){
        return repository.findById(idUsuario);
    }

}
