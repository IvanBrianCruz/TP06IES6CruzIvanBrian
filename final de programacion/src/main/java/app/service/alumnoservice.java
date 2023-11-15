package app.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Alumno;
import app.repository.alumnoRepository;
import jakarta.transaction.Transactional;

@Service
public class alumnoservice {
	@Autowired
	alumnoRepository alumnoRepository;

	public void guardarAlumno(Alumno alumno) {
		// guardar alumno
		alumno.getState(true);
		alumnoRepository.save(alumno);
	}
	@Transactional
    public void eliminarAlumnoPorDNI(String dni) {
        alumnoRepository.deleteByDNI(dni);
    }
	

	public List<Alumno> buscarAlumno() {
		// LISTAR
		// List<Alumno> listado = new ArrayList<>();
		// return listado;
		return (List<Alumno>) alumnoRepository.findAll();

	}
	public Alumno buscarAlumnoPorDNI(String dni) {
        return alumnoRepository.findById(dni).orElse(null);
    }

}