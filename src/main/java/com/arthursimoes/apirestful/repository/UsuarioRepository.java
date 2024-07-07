package com.arthursimoes.apirestful.repository;

import com.arthursimoes.apirestful.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByContaAndSenha(String conta, String senha);
}
