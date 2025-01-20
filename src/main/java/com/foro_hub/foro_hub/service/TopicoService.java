package com.foro_hub.foro_hub.service;



import com.foro_hub.foro_hub.model.Topico;
import com.foro_hub.foro_hub.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Transactional
    public Topico crearTopico(Topico topico) {
        if (topicoRepository.existsByTituloAndMensaje(topico.getTitulo(), topico.getMensaje())) {
            throw new IllegalArgumentException("El tópico ya existe con el mismo título y mensaje.");
        }
        return topicoRepository.save(topico);
    }

    public List<Topico> obtenerTodosLosTopicos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerTopicoPorId(Long id) {
        return topicoRepository.findById(id);
    }

    @Transactional
    public Topico actualizarTopico(Long id, Topico topicoActualizado) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(topicoActualizado.getTitulo());
            topico.setMensaje(topicoActualizado.getMensaje());
            topico.setStatus(topicoActualizado.getStatus());
            topico.setAutor(topicoActualizado.getAutor());
            topico.setCurso(topicoActualizado.getCurso());
            return topicoRepository.save(topico);
        }).orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));
    }

    @Transactional
    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new IllegalArgumentException("El tópico no existe");
        }
        topicoRepository.deleteById(id);
    }
}
