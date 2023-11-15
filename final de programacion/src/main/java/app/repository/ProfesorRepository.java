package app.repository;

import org.springframework.stereotype.Repository;
import app.models.Profesor;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, String> {
    void deleteByDNI(String dni);
    // Aquí podrías definir otros métodos de acceso a datos para profesores si los necesitas
}
