package app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import models.Alumno;

import java.util.List;
import java.util.ArrayList;

@Controller
public class ControllersAlumno {

    private List<Alumno> listaDeAlumnos = new ArrayList<>();

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "cargaDeAlumno"; // Vista del formulario
    }

    @PostMapping("/")
    public String guardarAlumno(Alumno alumno) {
        // Guardar el alumno en la lista
        listaDeAlumnos.add(alumno);
        return "redirect:/datos"; // Redirigir a la vista que muestra los alumnos
    }

    @GetMapping("/datos")
    public String mostrarAlumnos(Model model) {
        model.addAttribute("alumnos", listaDeAlumnos);
        return "datos"; // Vista para mostrar los alumnos
    }
}
