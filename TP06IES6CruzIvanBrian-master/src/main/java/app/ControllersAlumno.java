package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import app.models.Alumno;
import app.models.GestorAlumnos;
import app.service.alumnoservice;


import java.util.List;
//import java.util.ArrayList;



@Controller
public class ControllersAlumno {

    @Autowired
    private GestorAlumnos gestorAlumnos;
    @Autowired
    alumnoservice alumnoservice;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "cargaDeAlumno"; // Vista del formulario
    }

    @PostMapping("/")
    public String guardarAlumno(Alumno alumno) {
        // Guardar el alumno utilizando el gestor
        //gestorAlumnos.agregarAlumno(alumno);
        alumnoservice.guardarAlumno(alumno);
        alumnoservice.buscarAlumno();
        return "redirect:/datos"; // Redirigir a la vista que muestra los alumnos
    }
// no tocar hasta aqui
@GetMapping("/datos")
public String mostrarAlumnos(Model model) {
    List<Alumno> alumnos = alumnoservice.buscarAlumno(); // Obtener la lista de alumnos desde la base de datos
    model.addAttribute("alumnos", alumnos);
    return "datos"; // Vista para mostrar los alumnos
}
    //METODOS PARA ELIMINAR UN ALUMNO DEL ARRAY
    

   

  //método para elimar un registro
    @GetMapping("/eliminarAlumno/{dni}")
    public ModelAndView eliminarAlumno(@PathVariable String dni) {
        List<Alumno> listaAlumnos = gestorAlumnos.obtenerAlumnos(); // Obtener la lista de alumnos

        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getDNI().equals(dni)) {
                listaAlumnos.remove(i);
                break; // Importante: salir del bucle una vez que se encuentra el alumno
            }
        }

        // Actualizamos la lista de alumnos en el gestor (si es necesario)
        gestorAlumnos.setAlumnos(listaAlumnos);

        ModelAndView modelView = new ModelAndView("datos"); // Redirigir a la vista de datos
        modelView.addObject("alumnos", listaAlumnos); // Usa el nombre correcto de la variable en tu vista
        return modelView;
    }
   

}
