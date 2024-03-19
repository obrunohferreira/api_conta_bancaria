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
<<<<<<< HEAD
    public Usuario salvaUsuario(String nome, String cpf){
=======
    public Usuario salvarUsuario(String nome, String cpf){
>>>>>>> dae300aba825dd54cbd88a7c25c00aed8ab49d78
        Usuario usuario = new Usuario(nome, cpf);
        return repository.save(usuario);
    }

<<<<<<< HEAD
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
=======
    //Atualiza um usuario
    public Usuario atualizarUsuario(Long idUsuario, Usuario usuario){
>>>>>>> dae300aba825dd54cbd88a7c25c00aed8ab49d78
        //Verifica se o usuário existe no banco de dados
        Optional<Usuario> usuarioOptional = repository.findById(idUsuario);
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idUsuario);
        }

        return repository.saveAndFlush(usuario);
<<<<<<< HEAD

=======
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
>>>>>>> dae300aba825dd54cbd88a7c25c00aed8ab49d78
    }

}
