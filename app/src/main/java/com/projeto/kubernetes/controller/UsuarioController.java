package com.projeto.kubernetes.controller;

import com.projeto.kubernetes.model.Usuario;
import com.projeto.kubernetes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> matarMaquina(@RequestBody Usuario usuario){
        var usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }
}
