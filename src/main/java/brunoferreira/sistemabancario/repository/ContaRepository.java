package brunoferreira.sistemabancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import brunoferreira.sistemabancario.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
