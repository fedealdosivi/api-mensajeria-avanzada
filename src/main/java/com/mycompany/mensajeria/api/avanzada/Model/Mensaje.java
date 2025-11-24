package com.mycompany.mensajeria.api.avanzada.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MENSAJES")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMENSAJE")
    private Integer id;

    @NotBlank
    @Column(name = "ASUNTO")
    private String asunto;

    @ManyToOne
    @JoinColumn(name = "IDREMITENTE", nullable = false)
    private Usuario remitente;

    @ManyToMany
    @JoinTable(
        name = "MENSAJE_DESTINATARIOS",
        joinColumns = @JoinColumn(name = "IDMENSAJE"),
        inverseJoinColumns = @JoinColumn(name = "IDUSUARIO")
    )
    private List<Usuario> destinatarios = new ArrayList<>();

    @Column(name = "CUERPO", columnDefinition = "TEXT")
    private String body;

    @Column(name = "FECHA_ENVIO")
    private LocalDateTime fechaEnvio;

    public Mensaje() {
        this.fechaEnvio = LocalDateTime.now();
    }

    public Mensaje(String asunto, Usuario remitente, String body) {
        this.asunto = asunto;
        this.remitente = remitente;
        this.body = body;
        this.fechaEnvio = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public List<Usuario> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<Usuario> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
