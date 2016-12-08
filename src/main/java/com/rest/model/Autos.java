package com.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.metamodel.StaticMetamodel;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ezequ on 12/3/2016.
 */
@Entity
@Table(name = "AUTOS")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Autos implements Serializable {

    private Integer id;
    private String marca;
    private String modelo;
    private String matricula;
    private String anio;
    private String color;
    private String combustible;
    private Date fecharegistro;
    private Date fechaactualizacion;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MARCA", nullable = false, length = 70)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "MODELO", nullable = false, length = 100)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Basic
    @Column(name = "MATRICULA", nullable = false, length = 8)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Basic
    @Column(name = "ANIO", nullable = true, length = 5)
    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Basic
    @Column(name = "COLOR", nullable = true, length = 20)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "COMBUSTIBLE", nullable = true, length = 20)
    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Basic
    @Column(name = "FECHAREGISTRO", nullable = true ,insertable = false)
    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Basic
    @Column(name = "FECHAACTUALIZACION", nullable = true ,insertable = false)
    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }


}
