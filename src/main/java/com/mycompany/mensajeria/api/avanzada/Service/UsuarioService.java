package com.mycompany.mensajeria.api.avanzada.Service;

import com.mycompany.mensajeria.api.avanzada.Model.Usuario;
import com.mycompany.mensajeria.api.avanzada.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cargarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> traerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> traerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> traerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Optional<Usuario> traerUsuarioPorNickName(String nickName) {
        return usuarioRepository.findByNickName(nickName);
    }
}
