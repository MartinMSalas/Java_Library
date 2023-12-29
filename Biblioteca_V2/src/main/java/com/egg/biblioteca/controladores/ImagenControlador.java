package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/perfil/{idUsuario}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable String idUsuario) throws MiException {

        Optional<Usuario> usuario = usuarioServicio.findById(idUsuario);
        return ResponseEntity.ok(usuario.get().getImagen().getContenido());
    }

}
