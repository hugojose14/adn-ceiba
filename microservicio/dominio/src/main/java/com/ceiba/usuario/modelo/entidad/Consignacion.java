package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Consignacion {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String identificacion;
    private BigDecimal cantidadConsignada;

    public Consignacion(Long id, String nombre, String apellido, String telefono, String direccion, String identificacion, BigDecimal cantidadConsignada) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.cantidadConsignada = cantidadConsignada;
    }
}
