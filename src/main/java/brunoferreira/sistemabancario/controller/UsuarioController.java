package brunoferreira.sistemabancario.controller;

import brunoferreira.sistemabancario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import brunoferreira.sistemabancario.model.Usuario;
import brunoferreira.sistemabancario.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    //Injetando o a classe service
    @Autowired
    private UsuarioService service;

    //Salva um novo usuario
    @PostMapping("/salvarUsuario")
    @ResponseStatus(HttpStatus.OK)
    public Usuario salvarUsuario(@RequestParam String nome,
                                 @RequestParam String cpf){
        return service.salvarUsuario(nome, cpf);
    }

    //Lista todos os usuarios
    @GetMapping("/listarUsuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarUsuarios(){
        return service.listarUsuarios();
    }

    //Retorna usuario pelo ID
    @GetMapping("/listarUsuarioId")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Usuario> listarUsuarioId(@RequestParam Long idUsuario){
        return service.listarUsuarioId(idUsuario);
    }

    //Atualiza usuario pelo ID
    @PutMapping("/atualizarUsuario/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizarUsuario(@PathVariable Long idUsuario, @RequestBody Usuario usuario){

        return service.atualizarUsuario(idUsuario, usuario);
    }

    //Apaga usuario pelo ID
    @DeleteMapping("/apagarUsuarioId")
    @ResponseStatus(HttpStatus.OK)
    public void apagarUsuarioId(@RequestParam Long idUsuario){
        service.apagarUsuario(idUsuario);
    }

}
