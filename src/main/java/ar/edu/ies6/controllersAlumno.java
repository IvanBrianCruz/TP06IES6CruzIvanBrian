package ar.edu.ies6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class controllersAlumno {
    
    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        // Crear un objeto Alumno vacío y pasarlo al formulario
        Alumno alumno = new Alumno();
        model.addAttribute("alumno", alumno);
        return "cargaDeAlumno"; // Nombre de la vista del formulario
    }
   
}
