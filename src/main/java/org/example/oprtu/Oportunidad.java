package org.example.oprtu;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Oportunidad {


    @Id
    private long id;
    private String nombre;
    private String contrasena;
    //0 one way - 1 round trip false 0 , true 1


    public Oportunidad(String nombre, String contrasena) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;

    }
}
