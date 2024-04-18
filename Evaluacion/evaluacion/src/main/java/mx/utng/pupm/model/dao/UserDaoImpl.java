package mx.utng.pupm.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.pupm.model.entity.User;

@Repository
public class UserDaoImpl implements IUserDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<User> list() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public void save(User user) {
        System.out.println("User id="+user.getId());
        if(user.getId() != null && user.getId() >0){
            //Actualizo estudiante
            em.merge(user);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(user);
        }
    }

    @Override
    public User getById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        User user = getById(id);
        em.remove(user);
    }

    
}