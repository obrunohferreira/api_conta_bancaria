package brunoferreira.sistemabancario.controller;

import brunoferreira.sistemabancario.model.Conta;
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

    //Salva um novo usuario
    @PostMapping("/salvarUsuario")
    @ResponseStatus(HttpStatus.OK)
    public Usuario salvarUsuario(@RequestParam String nome,
                                 @RequestParam String cpf){

        return service.salvarUsuario(nome, cpf);
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

    //Retorna todos usuarios cadastrados
    @GetMapping("/listarUsuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarUsuarios(){
        return service.listarUsuarios();
    }

    //Retorna usuario por seu id
    @GetMapping("/listarUsuarioId")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Usuario> listarUsuarioId(@RequestParam Long idUsuario){
        return service.listarUsuarioId(idUsuario);
    }

}
