package com.example.demo.oportuControler;

import com.example.demo.oportuService.ContactoService;
import com.example.demo.oprtu.Contacto;
import com.example.demo.oprtu.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class ContactoController {

    private final ContactoService contactoService;

    @Autowired
    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }
    @GetMapping(path="api/v1/contactos")
    public List<Contacto> getContactos(){
        return contactoService.getContactos();
    }
    @GetMapping(path="api/v1/contactos/{id}")
    public Contacto getContactosId(@PathVariable Long id){
        return contactoService.getContactoById(id);
    }
    @GetMapping(path="api/v1/futuro")
    public List<Contacto> getContactosFuturo(){
        return contactoService.getContactoFuturo();
    }
}
