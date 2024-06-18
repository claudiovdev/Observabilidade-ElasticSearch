package com.projeto.kubernetes.repository;

import com.projeto.kubernetes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Boolean existsByNome(String nome);
}
