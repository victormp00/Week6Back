package com.example.demo.oportuService;

import com.example.demo.oprtu.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    public UsuarioService() {
    }

    private static Usuario usuario ;




    public static List<Usuario> getUsuarios(){
        return null;
    }
    public static Boolean comprobarLog(String nombre, String contraseña){
        Boolean existe = false;
        int i=0;
            if(usuario.getNombre().equals(nombre) && usuario.getContrasena().equals(contraseña)){
                existe=true;
        }
        return existe;

    }
}
