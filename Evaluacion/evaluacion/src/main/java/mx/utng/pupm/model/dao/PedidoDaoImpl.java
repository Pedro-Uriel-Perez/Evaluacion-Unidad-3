package mx.utng.pupm.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.pupm.model.entity.Pedido;


@Repository
public class PedidoDaoImpl implements IPedidoDao{
     //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Pedido> list() {
        return em.createQuery("from Pedido").getResultList();
    }

    @Override
    public void save(Pedido pedido) {
        if(pedido.getId() != null && pedido.getId() >0){
            em.merge(pedido);
        }else{
            em.persist(pedido);
        }
    }

    @Override
    public Pedido getById(Long id) {
        return em.find(Pedido.class, id);
    }

    @Override
    public void delete(Long id) {
        Pedido pedido = getById(id);
        em.remove(pedido);
    }

    
}
