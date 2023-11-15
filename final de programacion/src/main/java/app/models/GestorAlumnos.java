package app.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestorAlumnos {
    private List<Alumno> listaDeAlumnos = new ArrayList<>();

    public void agregarAlumno(Alumno alumno) {
        listaDeAlumnos.add(alumno);
    }

    public List<Alumno> obtenerAlumnos() {
        return listaDeAlumnos;
    }

	public void setAlumnos(List<Alumno> alumnos) {
		// TODO Auto-generated method stub
		
	}
}
