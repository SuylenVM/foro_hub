package com.foro_hub.foro_hub.controller;



import com.foro_hub.foro_hub.model.Topico;
import com.foro_hub.foro_hub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping

    public ResponseEntity<Topico> crearTopico(@Valid @RequestBody Topico topico) {
        Topico nuevoTopico = topicoService.crearTopico(topico);
        return ResponseEntity.ok(nuevoTopico);
    }


    @GetMapping
    public ResponseEntity<List<Topico>> obtenerTodosLosTopicos() {
        return ResponseEntity.ok(topicoService.obtenerTodosLosTopicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        return topicoService.obtenerTopicoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico topico) {
        return ResponseEntity.ok(topicoService.actualizarTopico(id, topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}

