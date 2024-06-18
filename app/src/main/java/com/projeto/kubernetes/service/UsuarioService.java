package com.projeto.kubernetes.service;

import com.projeto.kubernetes.model.Usuario;
import com.projeto.kubernetes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        var validaNomeExistente = usuarioRepository.existsByNome(usuario.getNome());
        if (validaNomeExistente){
            throw new RuntimeException("Nome existente");
        }
        return usuarioRepository.save(usuario);
    }
}
