package com.example.demo.oportuService;

import com.example.demo.oprtu.Contacto;
import com.example.demo.oprtu.Oportunidad;


import java.util.Date;
import java.util.List;

public class ContactoService {

    public static List<Contacto> getContacto(){
        return null;
    }

    public static Contacto getContactoById(long id){
        return null;
    }
    public static List<Contacto> getContactoFuturo(){
        return null;
    }

    //sirve tambien para clientes pues solo se distinguen por la fecha
    public static boolean crearContacto(long id, String descripcion, Oportunidad oportunidad, Date fecha){
        return true;
    }
}
