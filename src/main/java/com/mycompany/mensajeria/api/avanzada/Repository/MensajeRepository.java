package com.mycompany.mensajeria.api.avanzada.Repository;

import com.mycompany.mensajeria.api.avanzada.Model.Mensaje;
import com.mycompany.mensajeria.api.avanzada.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    List<Mensaje> findByRemitente(Usuario remitente);
    List<Mensaje> findByDestinatariosContaining(Usuario destinatario);
    List<Mensaje> findByAsuntoContainingIgnoreCase(String asunto);
}
