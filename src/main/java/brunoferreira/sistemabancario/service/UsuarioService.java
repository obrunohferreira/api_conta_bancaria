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
    private UsuarioRepository usuarioRepository;

    //Para salvar um usuario
    public Usuario salvarUsuario(String nome, String cpf){
        Usuario usuario = new Usuario(nome, cpf);
        return usuarioRepository.save(usuario);
    }

    //Para autalizar um usuario por seu id
    public Usuario atualizarUsuario(Long idUsuario, Usuario usuarioAtualizado) {
        //Verifica se o usuário existe no banco de dados
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idUsuario);
        }

        //Obtem o usuário existente do Optional
        Usuario usuarioExistente = usuarioOptional.get();

        //Atualiza os campos do usuário existente com os valores do usuário atualizado
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setCpf(usuarioAtualizado.getCpf());

        return usuarioRepository.save(usuarioExistente);
    }

    //Para apagar um usuario por seu id
    public void apagarUsuario(Long idUsuario){
        //Verifica se o usuário existe no banco de dados
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado: " + idUsuario);
        }
        //Efetua a deleção
        usuarioRepository.deleteById(idUsuario);
    }

    //Para listar todos os usuarios no banco de dados
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    //Para listar o usuario por seu id
    public Optional<Usuario> listarUsuarioId(Long idUsuario){
        return usuarioRepository.findById(idUsuario);
    }

}
