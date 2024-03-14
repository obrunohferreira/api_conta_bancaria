package brunoferreira.sistemabancario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brunoferreira.sistemabancario.model.Usuario;
import brunoferreira.sistemabancario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario salvaUsuario(Usuario usuario){
        return repository.save(usuario);
    }

}
