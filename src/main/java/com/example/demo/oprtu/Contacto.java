package com.example.demo.oprtu;

import javax.persistence.Id;
import java.util.Date;

public class Contacto {

    @Id
    private long id;
    private String descripcion;
    private long idOportunidad;
    private Date fecha;
    //0 one way - 1 round trip false 0 , true 1


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdOportunidad() {
        return idOportunidad;
    }

    public void setIdOportunidad(long idOportunidad) {
        this.idOportunidad = idOportunidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", idOportunidad=" + idOportunidad +
                ", fecha=" + fecha +
                '}';
    }

    public Contacto(long id, String descripcion, long idOportunidad, Date fecha) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.idOportunidad = idOportunidad;
        this.fecha = fecha;

    }
}
