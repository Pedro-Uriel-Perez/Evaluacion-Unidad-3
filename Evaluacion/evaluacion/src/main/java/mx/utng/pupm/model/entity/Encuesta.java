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
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(length = 30)
    private String pregunta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column
    private int respuesta;

    @PrePersist
    public void prePersist() {
        fechaInicio = new Date();
        fechaFin = new Date(); // Fecha fin también se establece en la misma fecha en prePersist
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }
    

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    // Getter y Setter para el campo de respuesta
    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public int getRespuesta() {
        return respuesta;
    }
}
