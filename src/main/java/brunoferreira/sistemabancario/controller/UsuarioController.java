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
    @Autowired
    private UsuarioService service;

    @PostMapping("/salvarUsuario")
    @ResponseStatus(HttpStatus.OK)
    public Usuario salvarUsuario(@RequestParam String nome,
                                 @RequestParam String cpf){
        return service.salvaUsuario(nome, cpf);
    }

    @GetMapping("/listarUsuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarUsuarios(){
        return service.listaUsuarios();
    }

    @GetMapping("/listarUsuarioId")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Usuario> listarUsuarioId(@RequestParam Long idUsuario){
        return service.listaUsuarioId(idUsuario);
    }

    @PutMapping("/atualizarUsuario/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizarUsuario(@PathVariable Long idUsuario, @RequestBody Usuario usuario){

        return service.atualizaUsuario(idUsuario, usuario);
    }
}
