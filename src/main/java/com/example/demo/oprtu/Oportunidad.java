package com.example.demo.oprtu;

import org.openqa.selenium.devtools.v105.fetch.Fetch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Oportunidad {


    @Id
    private long id;
    @OneToMany(mappedBy = "oportunidad")
    private Set<Contacto> contactos;
    private boolean ConvertidoCliente;
    //0 one way - 1 round trip false 0 , true 1


    public Oportunidad() {
    }

    public Oportunidad( Set<Contacto> contactos, boolean ConvertidoCliente) {
        super();
        this.contactos = contactos;
        this.ConvertidoCliente = ConvertidoCliente;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Set<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(Set<Contacto> contactos) {
        this.contactos = contactos;
    }

    public boolean isConvertidoCliente() {
        return ConvertidoCliente;
    }

    public void setConvertidoCliente(boolean convertidoCliente) {
        ConvertidoCliente = convertidoCliente;
    }
}
