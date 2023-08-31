package com.istqmet.SprinJBC.controladores;

import com.istqmet.SprinJBC.entidades.Persona;
import com.istqmet.SprinJBC.repositorio.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonaController {
    @Autowired
    PersonaRepository personaRepository;


    //CRUD-READ-GET

    @GetMapping("/persona")
    public String listarPersona(Model model){
        List<Persona> personas= personaRepository.findAll();
        model.addAttribute("personas",personas);
        return "persona/listarPersona";
    }

    //CRUD-CREAT-POST
    @GetMapping("/persona/formulario")
    public String form(Model model){
        model.addAttribute("persona", new Persona());
        return "/persona/formPersona";
    }

    @PostMapping("/persona/formulario")
    public String crearPersona(Persona persona){
        personaRepository.save(persona);
        return "redirect:/persona";
    }

    //CRUD-UPDATE-PUT
    @GetMapping("persona/editar/{cedula}")
    public String editar(@PathVariable String cedula,Model model){
        Optional<Persona> persona = personaRepository.findById(cedula);
        model.addAttribute("persona", persona);
        return "/persona/formPersona";
    }

    //ELIMINAR
    @GetMapping("persona/eliminar/{cedula}")
    public String eliminar(@PathVariable String cedula){
        personaRepository.deleteById(cedula);
        return "redirect:/persona";
    }

}
