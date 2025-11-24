package com.mycompany.mensajeria.api.avanzada.Service;

import com.mycompany.mensajeria.api.avanzada.Model.Mensaje;
import com.mycompany.mensajeria.api.avanzada.Model.Usuario;
import com.mycompany.mensajeria.api.avanzada.Repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MensajeService {

    private final MensajeRepository mensajeRepository;

    @Autowired
    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    public Mensaje enviarMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    public List<Mensaje> traerTodos() {
        return mensajeRepository.findAll();
    }

    public Optional<Mensaje> traerMensajePorId(Integer id) {
        return mensajeRepository.findById(id);
    }

    public List<Mensaje> traerMensajesPorRemitente(Usuario remitente) {
        return mensajeRepository.findByRemitente(remitente);
    }

    public List<Mensaje> traerMensajesPorDestinatario(Usuario destinatario) {
        return mensajeRepository.findByDestinatariosContaining(destinatario);
    }

    public List<Mensaje> buscarPorAsunto(String asunto) {
        return mensajeRepository.findByAsuntoContainingIgnoreCase(asunto);
    }

    public void eliminarMensaje(Integer id) {
        mensajeRepository.deleteById(id);
    }
}
