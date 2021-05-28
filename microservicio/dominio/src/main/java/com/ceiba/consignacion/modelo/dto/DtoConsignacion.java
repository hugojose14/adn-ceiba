package com.ceiba.consignacion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class DtoConsignacion {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String identificacion;
    private BigDecimal cantidadConsignada;

}
