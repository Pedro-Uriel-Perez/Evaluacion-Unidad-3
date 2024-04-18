package mx.utng.pupm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.pupm.model.dao.IPedidoDao;
import mx.utng.pupm.model.entity.Pedido;
/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class PedidoServiceImpl implements IPedidoService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IPedidoDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<Pedido> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Pedido pedido) {
        dao.save(pedido);
    }

    @Transactional(readOnly = true)
    @Override
    public Pedido getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
