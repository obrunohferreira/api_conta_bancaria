package brunoferreira.sistemabancario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brunoferreira.sistemabancario.model.Conta;
import brunoferreira.sistemabancario.repository.ContaRepository;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvaConta(Conta conta){
        return contaRepository.save(conta);
    }

}
