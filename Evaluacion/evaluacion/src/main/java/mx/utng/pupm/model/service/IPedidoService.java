package mx.utng.pupm.model.service;

import java.util.List;

import mx.utng.pupm.model.entity.Pedido;

public interface IPedidoService {
    List<Pedido> list();
    void save(Pedido pedido);
    Pedido getById(Long id);
    void delete(Long id);
}