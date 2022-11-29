package com.example.demo.oprtu;

import javax.persistence.Id;

public class Usuario {

    @Id
    private long id;
    private String nombre;
    private String contrasena;
    //0 one way - 1 round trip false 0 , true 1


    public Usuario(String nombre, String contrasena) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
