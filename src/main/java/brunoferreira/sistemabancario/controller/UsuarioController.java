package brunoferreira.sistemabancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import brunoferreira.sistemabancario.model.Usuario;
import brunoferreira.sistemabancario.service.UsuarioService;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/salvarUsuario")
    @ResponseStatus(HttpStatus.OK)
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return service.salvaUsuario(usuario);
    }
}
