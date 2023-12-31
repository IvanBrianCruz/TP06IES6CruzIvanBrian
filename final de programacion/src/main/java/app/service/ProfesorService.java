package app.service;

import app.models.Profesor;
import app.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    public void guardarProfesor(Profesor profesor) {
        // guardar profesor
        profesorRepository.save(profesor);
    }

    @Transactional
    public void eliminarProfesorPorDNI(String dni) {
         Optional<Profesor> optionalProfesor = profesorRepository.findById(dni);

    optionalProfesor.ifPresent(Profesor -> {
        Profesor.setState(false);
        profesorRepository.save(Profesor);
    });
    }

    public List<Profesor> buscarProfesores() {
        return (List<Profesor>) profesorRepository.findAll();
    }

    public Profesor buscarProfesorPorDNI(String dni) {
        return profesorRepository.findById(dni).orElse(null);
    }
}

