package com.example.demo.oportuService;

import com.example.demo.oprtu.Contacto;
import com.example.demo.oprtu.Oportunidad;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OportunidadService {
    static Set<Contacto> contactosCoche = new HashSet<Contacto>();
    static Set<Contacto> contactosCasa = new HashSet<Contacto>();

    static Oportunidad coches = new Oportunidad(contactosCoche,false);
    static Oportunidad casas = new Oportunidad(contactosCasa,false);

    static Oportunidad CasaYaVendida = new Oportunidad(contactosCoche,true);
    static List<Oportunidad> oportunidades = new ArrayList<>();
    static {
        coches.setId(22);
        CasaYaVendida.setId(23);
        casas.setId(24);
        oportunidades.add(coches);
        oportunidades.add(CasaYaVendida);
        oportunidades.add(casas);
        Date fechaJuan = new Date(122,10,10);
        Date fechaFuturo = new Date(123,10,10);
        Contacto Juan = new Contacto("LLamada telefonica",coches,fechaJuan);
        Contacto Pedro = new Contacto("Correo electronico",coches,fechaJuan);
        Contacto Pepe = new Contacto("llamar el año que viene",coches,fechaFuturo);
        Contacto Miguel = new Contacto("Burofax",casas,fechaJuan);
        Contacto Jorge = new Contacto("Llamada al fijo",casas,fechaJuan);
        contactosCoche.add(Juan);
        contactosCoche.add(Pedro);
        contactosCoche.add(Pepe);
        contactosCasa.add(Miguel);
        contactosCasa.add(Jorge);
    }

    //sirve tambien para planes futuros pues solo se distinguen por la fecha
    public static boolean crearContacto(String descripcion, Oportunidad oportunidad, Date fecha){

        Contacto NuevoConctacto = new Contacto(descripcion,oportunidad,fecha);
        oportunidad.getContactos().add(NuevoConctacto);
        return true;
    }
    public static boolean crearOportunidad(Contacto contacto, boolean esCliente){
        Set<Contacto> contactosCasa = new HashSet<Contacto>();
        contactosCasa.add(contacto);
        Oportunidad nueva = new Oportunidad(contactosCasa,esCliente);
        oportunidades.add(nueva);
        return true;
    }
    public static List<Oportunidad> getOportunidades(){
        List<Oportunidad> oportunidadesNoCliente = new ArrayList<>();
        for(int i = 0;i < oportunidades.size(); i++){
            if(oportunidades.get(i).isConvertidoCliente()==false){
                oportunidadesNoCliente.add(oportunidades.get(i));
            }
        }
        return oportunidadesNoCliente;
    }
    public static Oportunidad getOportunidadByID(long id){
        for(int i = 0;i < oportunidades.size(); i++){
            if(oportunidades.get(i).getId()==(id)){
                return oportunidades.get(i);
            }
        }
        return null;
    }
    public static List<Oportunidad> getOportunidadesPorUsuario(){
        List<Oportunidad> oportunidadesNoCliente = new ArrayList<>();
        for(int i = 0;i < oportunidades.size(); i++){
            if(oportunidades.get(i).isConvertidoCliente()==false){
                oportunidadesNoCliente.add(oportunidades.get(i));
            }
        }
        return oportunidadesNoCliente;
    }

    public static boolean comprobarFecha(Contacto contacto){
        Date ahora = new Date(System.currentTimeMillis());
        if(contacto.getFecha().before(ahora)){
            return true;
        }else if(contacto.getFecha().equals(ahora)){
            return true;
        }
        return false;
    }
    public static boolean comprobarFechaFutura(Contacto contacto){
        Date ahora = new Date(System.currentTimeMillis());
        if(contacto.getFecha().after(ahora)){
            return true;
        }
        return false;
    }
    public static List<Contacto> getContactosOportunidadId(long id){
        Set<Contacto> contactos = getOportunidadByID(id).getContactos();
        List<Contacto> contactosPasados = new ArrayList<>();
        for (Contacto c : contactos) {
            if(comprobarFecha(c)){
                contactosPasados.add(c);
            };
        }
        return contactosPasados;
    }
    public static List<Contacto> getContactosPlanesFuturosId(long id){
        Set<Contacto> contactos = getOportunidadByID(id).getContactos();
        List<Contacto> contactosFuturos = new ArrayList<>();
        for (Contacto c : contactos) {
            if(comprobarFechaFutura(c)){
                contactosFuturos.add(c);
            };
        }
        return contactosFuturos;
    }
    public static void convertiraCLiente(long id){
        getOportunidadByID(id).setConvertidoCliente(true);
    }

    public static List<Oportunidad> getClientes(){
        List<Oportunidad> oportunidadesCliente = new ArrayList<>();
        for(int i = 0;i < oportunidades.size(); i++){
            if(oportunidades.get(i).isConvertidoCliente()==true){
                oportunidadesCliente.add(oportunidades.get(i));
            }
        }
        return oportunidadesCliente;
    }




}
