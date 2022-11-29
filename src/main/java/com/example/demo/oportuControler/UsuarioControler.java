package com.example.demo.oportuControler;

import com.example.demo.oportuService.UsuarioService;
import com.example.demo.oprtu.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class UsuarioControler {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioControler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(path="api/v1/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping(path="api/v1/usuario/{nombre}/lineas/{contrasena}")
    public Boolean ComprobarLog(@PathVariable String nombre,@PathVariable String contrasena){
        return usuarioService.comprobarLog(nombre,contrasena);
    }

}
