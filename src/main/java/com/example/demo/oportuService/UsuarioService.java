package com.example.demo.oportuService;

import com.example.demo.oprtu.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    public UsuarioService() {
    }
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuario = new Usuario("admin","admin");
	static {

        usuarios.add(usuario);

    }



    public static List<Usuario> getUsuarios(){
        return usuarios;
    }

    //Solo mira el usuario en vez de usuarios porque por ahora solo hay un usuario
    public static Boolean comprobarLog(String nombre, String contraseña){
        Boolean existe = false;
        int i=0;
            if(usuario.getNombre().equals(nombre) && usuario.getContrasena().equals(contraseña)){
                existe=true;
        }
        return existe;

    }
}
