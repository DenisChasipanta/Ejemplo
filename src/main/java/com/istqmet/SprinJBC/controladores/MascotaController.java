package com.istqmet.SprinJBC.controladores;

import com.istqmet.SprinJBC.entidades.Mascota;
import com.istqmet.SprinJBC.entidades.Persona;
import com.istqmet.SprinJBC.repositorio.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MascotaController {
    @Autowired
    MascotaRepository mascotaRepository;

    @GetMapping("/listarMascota")
    public String masc(){
        return "listarMascota";
    }
    @GetMapping("/formMascota")
    public String masco(){
        return "formMascota";
    }

    @GetMapping ("/mascota")
    public String listarMascota(Model model){
        List<Mascota> mascotas= mascotaRepository.findAll();
        model.addAttribute("mascotas",mascotas);
        return "mascota/listarMascota";
    }


    @GetMapping("/mascota/formulario")
    public String form(Model model){
        model.addAttribute("mascota", new Mascota());
        return "/mascota/formMascota";
    }
    @PostMapping("/mascota/formulario")
    public String crearMascota(Mascota mascota){
        mascotaRepository.save(mascota);
        return "redirect:/mascota";
    }
    @GetMapping("mascota/editar/{especie}")
    public String editar(@PathVariable Integer id, Model model){
        Optional<Mascota> mascota= mascotaRepository.findById(id);
        model.addAttribute("mascota",mascota);
        return "/mascota/formMascota";
    }
    @GetMapping("mascota/eleminar/{id}")
    public String eliminar(@PathVariable Integer id){
        mascotaRepository.deleteById(id);
        return "redirect:/mascota";
    }

}
