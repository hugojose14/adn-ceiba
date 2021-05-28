package com.ceiba.consignacion.servicio.testdatabuilder;

import com.ceiba.consignacion.modelo.entidad.Consignacion;
import java.math.BigDecimal;
import java.util.UUID;

public class ConsignacionTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String identificacion;
    private BigDecimal cantidadConsignada;

    public ConsignacionTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        apellido = UUID.randomUUID().toString();
        telefono = UUID.randomUUID().toString();
        direccion = UUID.randomUUID().toString();
        identificacion = UUID.randomUUID().toString();
        cantidadConsignada = new BigDecimal(10000);
    }

    public ConsignacionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ConsignacionTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ConsignacionTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public ConsignacionTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ConsignacionTestDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public ConsignacionTestDataBuilder conCantidadConsignada(BigDecimal cantidadConsignada) {
        this.cantidadConsignada = cantidadConsignada;
        return this;

    }

    public ConsignacionTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

        public Consignacion build() {
        return new Consignacion(id,nombre, apellido,telefono,direccion,identificacion,cantidadConsignada);
    }

}
