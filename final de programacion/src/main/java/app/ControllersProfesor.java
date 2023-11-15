package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.util.StringUtils;

//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;

//import app.models.GestorAlumnos;


import app.models.Profesor;
//import app.service.UploadFileService;
import app.service.ProfesorService;

//import java.io.IOException;
import java.util.List;

@Controller
public class ControllersProfesor {
    
@Autowired
ProfesorService profesorService;


@PostMapping("/cargarProfesor")
public String guardarProfesor(@ModelAttribute Profesor profesor) {
    try {
        profesorService.guardarProfesor(profesor); // Guardar al profesor
        return "redirect:/datosProfesores"; // Redireccionar después de guardar
    } catch (Exception e) {
        // Manejo de errores
        return "redirect:/error";
    }
}




@GetMapping("/cargarProfesor")
public String mostrarFormularioProfesor(Model model) {
    model.addAttribute("profesor", new Profesor());
    return "cargaDeProfesor";
}

@GetMapping("/datosProfesores")
public String mostrarProfesores(Model model) {
    List<Profesor> profesores = profesorService.buscarProfesores();
    model.addAttribute("profesores", profesores);
    return "datosProfesores"; // Vista para mostrar los profesores
}

@GetMapping("/eliminarProfesor/{dni}")
public String eliminarProfesor(@PathVariable String dni) {
    profesorService.eliminarProfesorPorDNI(dni);
    return "redirect:/datosProfesores";
}

@GetMapping("/editarProfesor/{dni}")
public String editarProfesor(@PathVariable String dni, Model model) {
    Profesor profesor = profesorService.buscarProfesorPorDNI(dni);
    model.addAttribute("profesor", profesor);
    return "edicionProfesor";
}

@PostMapping("/actualizarProfesor")
public String actualizarProfesor(Profesor profesor) {
    profesorService.guardarProfesor(profesor);
    return "redirect:/datosProfesores";
}
}
