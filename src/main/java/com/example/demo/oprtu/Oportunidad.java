package com.example.demo.oprtu;

import org.openqa.selenium.devtools.v105.fetch.Fetch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Oportunidad {


    @Id
    private long id;
    private long idUsuario;
    @OneToMany(mappedBy = "oportunidad")
    private List<Contacto> contactos;
    private boolean ConvertidoCliente;
    //0 one way - 1 round trip false 0 , true 1


    public Oportunidad(long id, long idUsuario, List<Contacto> contactos, boolean ConvertidoCliente) {
        super();
        this.id = id;
        this.idUsuario = idUsuario;
        this.contactos = contactos;
        this.ConvertidoCliente = ConvertidoCliente;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public boolean isConvertidoCliente() {
        return ConvertidoCliente;
    }

    public void setConvertidoCliente(boolean convertidoCliente) {
        ConvertidoCliente = convertidoCliente;
    }
}
