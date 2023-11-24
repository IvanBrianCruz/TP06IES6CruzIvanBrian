package app.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestorProfesor {
    private List<Profesor> listaDeProfesores = new ArrayList<>();

    public void agregarProfesor(Profesor profesor) {
        listaDeProfesores.add(profesor);
    }

    public List<Profesor> obtenerProfesores() {
        return listaDeProfesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.listaDeProfesores = profesores;
    }
}
