package mx.utng.pupm.model.dao;

import java.util.List;

import mx.utng.pupm.model.entity.Encuesta;

public interface IEncuestaDao {
    List<Encuesta> list();
    void save(Encuesta encuesta);
    Encuesta getById(Long id);
    void delete(Long id);
}
