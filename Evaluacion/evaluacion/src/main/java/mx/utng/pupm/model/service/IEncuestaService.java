package mx.utng.pupm.model.service;

import mx.utng.pupm.model.entity.Encuesta;
import java.util.List;

public interface IEncuestaService {
    List<Encuesta> list();
    void save(Encuesta encuesta);
    Encuesta getById(Long id);
    void delete(Long id);
}