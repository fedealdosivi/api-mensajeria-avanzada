package com.mycompany.mensajeria.api.avanzada.Control;

import com.mycompany.mensajeria.api.avanzada.Model.Mensaje;
import com.mycompany.mensajeria.api.avanzada.Service.MensajeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControlMensajes {

    private final MensajeService mensajeService;

    @Autowired
    public ControlMensajes(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @GetMapping("/mensajes")
    public ResponseEntity<List<Mensaje>> traerTodos() {
        List<Mensaje> mensajes = mensajeService.traerTodos();
        return ResponseEntity.ok(mensajes);
    }

    @GetMapping("/mensaje/{id}")
    public ResponseEntity<Mensaje> mensajePorId(@PathVariable Integer id) {
        return mensajeService.traerMensajePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/mensaje")
    public ResponseEntity<Mensaje> enviarMensaje(@Valid @RequestBody Mensaje mensaje) {
        Mensaje nuevoMensaje = mensajeService.enviarMensaje(mensaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMensaje);
    }

    @DeleteMapping("/mensaje/{id}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable Integer id) {
        if (mensajeService.traerMensajePorId(id).isPresent()) {
            mensajeService.eliminarMensaje(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/mensajes/buscar")
    public ResponseEntity<List<Mensaje>> buscarPorAsunto(@RequestParam String asunto) {
        List<Mensaje> mensajes = mensajeService.buscarPorAsunto(asunto);
        return ResponseEntity.ok(mensajes);
    }
}
