package brunoferreira.sistemabancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import brunoferreira.sistemabancario.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
