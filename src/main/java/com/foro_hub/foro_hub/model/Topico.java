package com.foro_hub.foro_hub.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topicos", uniqueConstraints = @UniqueConstraint(columnNames = {"titulo", "mensaje"}))
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status = Status.ABIERTO;

    @NotBlank(message = "El autor no puede estar vacío")
    private String autor;

    @NotBlank(message = "El curso no puede estar vacío")
    private String curso;

    public enum Status {
        ABIERTO, CERRADO
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public @NotBlank(message = "El autor no puede estar vacío") String getAutor() {
        return autor;
    }

    public void setAutor(@NotBlank(message = "El autor no puede estar vacío") String autor) {
        this.autor = autor;
    }

    public @NotBlank(message = "El curso no puede estar vacío") String getCurso() {
        return curso;
    }

    public void setCurso(@NotBlank(message = "El curso no puede estar vacío") String curso) {
        this.curso = curso;
    }
}

