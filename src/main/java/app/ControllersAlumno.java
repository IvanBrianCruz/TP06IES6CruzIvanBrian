package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import models.Alumno;
import models.GestorAlumnos;

import java.util.List;


@Controller
public class ControllersAlumno {

    @Autowired
    private GestorAlumnos gestorAlumnos;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "cargaDeAlumno"; // Vista del formulario
    }

    @PostMapping("/")
    public String guardarAlumno(Alumno alumno) {
        // Guardar el alumno utilizando el gestor
        gestorAlumnos.agregarAlumno(alumno);
        return "redirect:/datos"; // Redirigir a la vista que muestra los alumnos
    }

    @GetMapping("/datos")
    public String mostrarAlumnos(Model model) {
        List<Alumno> alumnos = gestorAlumnos.obtenerAlumnos(); // Obtener la lista de alumnos del GestorAlumnos
        model.addAttribute("alumnos", alumnos);
        return "datos"; // Vista para mostrar los alumnos
    }
}
