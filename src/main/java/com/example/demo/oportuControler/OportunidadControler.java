package com.example.demo.oportuControler;

import com.example.demo.oportuService.OportunidadService;
import com.example.demo.oprtu.Contacto;
import com.example.demo.oprtu.Oportunidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
@CrossOrigin
public class OportunidadControler {
    private final OportunidadService oportunidadService;

    @Autowired
    public OportunidadControler(OportunidadService oportunidadService) {
        this.oportunidadService = oportunidadService;
    }
    @GetMapping(path="api/v1/oprtunidad")
    public List<Oportunidad> getOportunidades(){
        return oportunidadService.getOportunidades();
    }
    @GetMapping(path="api/v1/clientes")
    public List<Oportunidad> getClientes(){
        return oportunidadService.getClientes();
    }
    @GetMapping(path="api/v1/oprtunidad/contactos/{id}")
    public List<Contacto> getContactosPorOpr(@PathVariable Long id){
        return oportunidadService.getContactosOportunidadId(id);
    }
    @GetMapping(path="api/v1/oprtunidad/futuro/{id}")
    public List<Contacto> getContactosFuturosPorOpr(@PathVariable Long id){
        return oportunidadService.getContactosPlanesFuturosId(id);
    }
    @PostMapping(path="api/v1/oportunidad/convertir/{id}")
    public void convdertirCliente(@PathVariable Long id){
        oportunidadService.convertiraCLiente(id);
    }
    @PostMapping(path="api/v1/oprtunidad/contacto/{descripcion}/{oportunidad}/{fecha}")
    public Boolean crearContacto(@PathVariable String descripcion, @PathVariable Oportunidad oportunidad, @PathVariable Date fecha ){
        return oportunidadService.crearContacto(descripcion,oportunidad,fecha);
    }
    @PostMapping(path="api/v1/oportunidad/{contacto}/{esCliente}")
    public Boolean crearOportunidad(@PathVariable Contacto contacto,@PathVariable boolean esCliente ){
        return oportunidadService.crearOportunidad(contacto,esCliente);
    }
}
