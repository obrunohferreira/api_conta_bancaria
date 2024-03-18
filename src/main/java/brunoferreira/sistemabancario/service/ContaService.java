package brunoferreira.sistemabancario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.repository.ContaRepository;

import java.util.List;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    //Para listar todas as contas existentes:
    public List<Conta>listaContas(){
        return contaRepository.findAll();
    }

    //Para salvar uma conta:
    public Conta salvaConta(Conta conta){
        return contaRepository.save(conta);
    }
}
