package com.example.demo.oportuService;

import com.example.demo.oprtu.Contacto;
import com.example.demo.oprtu.Oportunidad;
import com.example.demo.oprtu.Usuario;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.*;
@Service
public class ContactoService {
    static List<Contacto> contactos = new ArrayList<>();
    static {
        Set<Contacto> contactosConc = new HashSet<Contacto>();
        Oportunidad JuanOpo = new Oportunidad(contactosConc,false);
        JuanOpo.setId(50);
        Date fechaJuan = new Date(122,10,10);
        Contacto juan = new Contacto("intercambio de fax",JuanOpo,fechaJuan);
        juan.setId(50);
        Date fechaFuturo = new Date(123,10,10);
        Contacto futuro = new Contacto("intercambio de cartas",JuanOpo,fechaFuturo);
        futuro.setId(60);
        contactos.add(juan);
        contactos.add(futuro);
    }
    //esta no tiene uso debido a que se busca mejor desde oportunidad
    public static List<Contacto> getContactos(){
        List<Contacto> contactosPasados = new ArrayList<>();
        Date ahora = new Date(System.currentTimeMillis());
        for(int i = 0;i < contactos.size(); i++){
            if(contactos.get(i).getFecha().before(ahora)){
                contactosPasados.add(contactos.get(i));
            }else if(contactos.get(i).getFecha().equals(ahora)){
                contactosPasados.add(contactos.get(i));
            }
        }
        return contactosPasados;
    }

    public static Contacto getContactoById(long id){
        for(int i = 0;i < contactos.size(); i++){
            if(contactos.get(i).getId()==(id)){
                return contactos.get(i);
            }
        }
            return null;
    }
    public static List<Contacto> getContactoFuturo(){
        List<Contacto> contactosFuturos = new ArrayList<>();
        Date ahora = new Date(System.currentTimeMillis());
        for(int i = 0;i < contactos.size(); i++){
            if(contactos.get(i).getFecha().after(ahora)){
                contactosFuturos.add(contactos.get(i));
            }
        }
        return contactosFuturos;
    }


}
