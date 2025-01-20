package com.foro_hub.foro_hub.controller;


import com.foro_hub.foro_hub.model.Usuario;
import com.foro_hub.foro_hub.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> request) {
        Usuario usuario = new Usuario();
        usuario.setUsername(request.get("username"));
        usuario.setPassword(passwordEncoder.encode(request.get("password")));
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }
}
