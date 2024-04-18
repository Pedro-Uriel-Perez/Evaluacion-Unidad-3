package mx.utng.pupm.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.pupm.model.entity.Encuesta;
/*
 * Clase repositorio o dao, utilizare la 
 * anotacion @Repository
 */

 @Repository
 public class EncuestaDaoImpl implements IEncuestaDao {
 
     @PersistenceContext
     private EntityManager entityManager;
 

     @Override
     public List<Encuesta> list() {
         return entityManager.createQuery("From Encuesta", Encuesta.class).getResultList();
     }
 
     @Override
     public void save(Encuesta encuesta) {
         System.out.println("library id=" + encuesta.getId());
         if (encuesta.getId() != null && encuesta.getId() > 0) {
             // Actualizo la entidad existente
             entityManager.merge(encuesta);
         } else {
             // Creo una nueva entidad en la base de datos
             entityManager.persist(encuesta);
         }
     }
 
     @Override
     public Encuesta getById(Long id) {
         return entityManager.find(Encuesta.class, id);
     }
 
     @Override
     public void delete(Long id) {
         Encuesta encuesta = getById(id);
         entityManager.remove(encuesta);
     }
 }
