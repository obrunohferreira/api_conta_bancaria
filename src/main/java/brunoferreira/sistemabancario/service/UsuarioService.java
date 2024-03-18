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
    public Usuario salvarUsuario(String nome, String cpf){
        Usuario usuario = new Usuario(nome, cpf);
        return repository.save(usuario);
    }

    //Atualiza um usuario
    public Usuario atualizarUsuario(Long idUsuario, Usuario usuario){
        //Verifica se o usuário existe no banco de dados
        Optional<Usuario> usuarioOptional = repository.findById(idUsuario);
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idUsuario);
        }

        return repository.saveAndFlush(usuario);
    }

    //Apaga um usuario
    public void apagarUsuario(Long idUsuario){
        //Verifica se o usuário existe no banco de dados
        Optional<Usuario> usuarioOptional = repository.findById(idUsuario);
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idUsuario);
        }

        repository.deleteById(idUsuario);
    }

    //Lista todos usuarios
    public List<Usuario> listarUsuarios(){
        return repository.findAll();
    }

    //Lista usuario por id
    public Optional<Usuario> listarUsuarioId(Long idUsuario){
        return repository.findById(idUsuario);
    }

}
