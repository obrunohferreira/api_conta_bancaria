package brunoferreira.sistemabancario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brunoferreira.sistemabancario.model.Usuario;
import brunoferreira.sistemabancario.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    //Salva um usuario
    public Usuario salvaUsuario(String nome, String cpf){
        Usuario usuario = new Usuario(nome, cpf);
        return repository.save(usuario);
    }

    //Lista todos usuarios
    public List<Usuario> listaUsuarios(){
        return repository.findAll();
    }

    //Lista usuario por id
    public Optional<Usuario> listaUsuarioId(Long idUsuario){
        return repository.findById(idUsuario);
    }

    //Atualiza um usuario
    public Usuario atualizaUsuario(Long idUsuario, Usuario usuario){
        //Verifica se o usuário existe no banco de dados
        Optional<Usuario> usuarioOptional = repository.findById(idUsuario);
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idUsuario);
        }

        return repository.saveAndFlush(usuario);

    }

}
