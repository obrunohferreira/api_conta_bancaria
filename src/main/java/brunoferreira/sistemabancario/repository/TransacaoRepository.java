package brunoferreira.sistemabancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import brunoferreira.sistemabancario.model.Transacao;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    //fornece a consulta para o extrato na classe ContaService
    @Query("SELECT t FROM Transacao t WHERE t.conta.id = :idConta")
    List<Transacao> extrato(Long idConta);
}
