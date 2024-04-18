package mx.utng.pupm.model.dao;


import java.util.List;

import mx.utng.pupm.model.entity.Pedido;

public interface IPedidoDao {
    List<Pedido> list();
    void save(Pedido pedido);
    Pedido getById(Long id);
    void delete(Long id);
}
