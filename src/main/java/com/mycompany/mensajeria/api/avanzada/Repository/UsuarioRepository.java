package com.mycompany.mensajeria.api.avanzada.Repository;

import com.mycompany.mensajeria.api.avanzada.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByNickName(String nickName);
}
