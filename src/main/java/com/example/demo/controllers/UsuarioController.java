package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.usuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    usuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {

        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }
   
      @GetMapping(path = "/{id}")
      public Optional<UsuarioModel> obtnerUsuarioPorId(@PathVariable("id") Long id)
      {
      return this.usuarioService.obtenerPorId(id);
      }
      
      
      @DeleteMapping( path = "/{id}")
      public String eliminarPorId(@PathVariable("id") Long id) {
      boolean ok = this.usuarioService.eliminarUsuario(id);
      if (ok) {
      return "Se elimino el usuario con id " + id;
      } else {
      return "No se pudo eliminar usuario con id " + id;
      }
      }
     
}
