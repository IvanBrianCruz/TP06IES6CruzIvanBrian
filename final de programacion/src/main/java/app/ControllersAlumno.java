package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;

import app.models.Alumno;
//import app.models.GestorAlumnos;
import app.service.alumnoservice;


import java.util.List;
//import java.util.ArrayList;

@Controller
public class ControllersAlumno {

    // @Autowired
    // private GestorAlumnos gestorAlumnos;
    @Autowired
    alumnoservice alumnoservice;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/cargarAlumno")
    public String mostrarFormularioAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "cargaDeAlumno"; // Vista del formulario
    }

    @PostMapping("/cargarAlumno")
    public String guardarAlumno(Alumno alumno) {
        // Guardar el alumno utilizando el gestor
        // gestorAlumnos.agregarAlumno(alumno);
        alumnoservice.guardarAlumno(alumno);
        alumnoservice.buscarAlumno();
        return "redirect:/datos"; // Redirigir a la vista que muestra los alumnos
    }

    // no tocar hasta aqui esto muestra los datos a db a la vista
    @GetMapping("/datos")
    public String mostrarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoservice.buscarAlumno(); // Obtener la lista de alumnos desde la base de datos
        model.addAttribute("alumnos", alumnos);
        return "datos"; // Vista para mostrar los alumnos
    }
    // METODOS PARA ELIMINAR UN ALUMNO DEL ARRAY

    @GetMapping("/eliminarAlumno/{dni}")
    public String eliminarAlumno(@PathVariable String dni) {
        alumnoservice.eliminarAlumnoPorDNI(dni); // Llamar al método del servicio para eliminar por DNI
        return "redirect:/datos"; // Redirigir a la vista de datos
    }

    // Método para mostrar la vista de edición
    @GetMapping("/editarAlumno/{dni}")
    public String editarAlumno(@PathVariable String dni, Model model) {
        Alumno alumno = alumnoservice.buscarAlumnoPorDNI(dni);
        model.addAttribute("alumno", alumno);
        return "edicionAlumno";
    }

    // Método para actualizar los datos del alumno
    @PostMapping("/editarAlumno")
    public String actualizarAlumno(Alumno alumno) {
        // Actualizar el alumno con los nuevos datos
        alumnoservice.guardarAlumno(alumno);
        return "redirect:/datos"; // Redirigir a la vista que muestra los alumnos
    }
//controlador de profesor ==========================================================================================================/

}
