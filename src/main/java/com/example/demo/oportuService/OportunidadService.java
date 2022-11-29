package com.example.demo.oportuService;

import com.example.demo.oprtu.Contacto;
import com.example.demo.oprtu.Oportunidad;

import java.util.*;

public class OportunidadService {
    static Set<Contacto> contactosCoche = new HashSet<Contacto>();
    static Oportunidad coches = new Oportunidad(22,1,contactosCoche,false);
    static Oportunidad CasaYaVendida = new Oportunidad(22,1,contactosCoche,true);
    static List<Oportunidad> oportunidades = new ArrayList<>();
    static {
        oportunidades.add(coches);
        Date fechaJuan = new Date(2022,10,10);
        Contacto Juan = new Contacto(22,"LLamada telefonica",coches,fechaJuan);
        Contacto Pedro = new Contacto(23,"Correo electronico",coches,fechaJuan);
        contactosCoche.add(Juan);
        contactosCoche.add(Pedro);
    }

    public static List<Oportunidad> getOportunidades(){
        return oportunidades;
    }
    public static List<Oportunidad> getOportunidadesPorUsuario(){
        return oportunidades;
    }
    public static List<Contacto> getContactosOportunidad(){
        return null;
    }
    public static void convertiraCLiente(Oportunidad oportunidad){}

    public static List<Oportunidad> getClientes(){ return null; }




}
