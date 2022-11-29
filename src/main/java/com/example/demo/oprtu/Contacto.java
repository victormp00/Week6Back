package com.example.demo.oprtu;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Contacto {

    @Id
    private long id;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_oportunidad")
    private Oportunidad oportunidad;
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

    public Oportunidad getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(Oportunidad oportunidad) {
        this.oportunidad = oportunidad;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", oportunidad=" + oportunidad +
                ", fecha=" + fecha +
                '}';
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Contacto(long id, String descripcion, Oportunidad oportunidad, Date fecha) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.oportunidad = oportunidad;
        this.fecha = fecha;

    }
}
