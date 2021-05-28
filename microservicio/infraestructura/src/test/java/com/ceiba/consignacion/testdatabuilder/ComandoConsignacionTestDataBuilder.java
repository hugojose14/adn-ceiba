package com.ceiba.consignacion.testdatabuilder;

import com.ceiba.consignacion.comando.ComandoConsignacion;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.math.BigDecimal;
import java.util.UUID;

public class ComandoConsignacionTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String identificacion;
    private BigDecimal cantidadConsignada;

    public ComandoConsignacionTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        apellido = UUID.randomUUID().toString();
        telefono = UUID.randomUUID().toString();
        direccion = UUID.randomUUID().toString();
        identificacion = UUID.randomUUID().toString();
        cantidadConsignada = new BigDecimal(10000);
    }

    public ComandoConsignacion build() {
        return new ComandoConsignacion(id,nombre, apellido,telefono,direccion,identificacion,cantidadConsignada);
    }


}
