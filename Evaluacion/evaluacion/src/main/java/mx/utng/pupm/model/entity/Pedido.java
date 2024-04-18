package mx.utng.pupm.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(length = 90)
    private String cliente;

    @NotEmpty
    @Column(length = 90)
    private String estado;

    @Column
    private double total;
   
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @PrePersist
    public void prePersist(){
        fechaPedido = new Date();
    }




    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }


    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}

