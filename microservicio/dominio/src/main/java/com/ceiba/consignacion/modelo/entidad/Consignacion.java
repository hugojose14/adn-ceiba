package com.ceiba.consignacion.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Consignacion {

    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_APELLIDO = "Se debe ingresar el apellido";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar la dirección";
    private static final String SE_DEBE_INGRESAR_TELEFONO = "Se debe ingresar el teléfono";
    private static final String SE_DEBE_INGRESAR_IDENTIFICACION = "Se debe ingresar la identificación";
    private static final String SE_DEBE_INGRESAR_CANTIDAD_CONSIGNADA = "Se debe ingresar la cantidad consignada";
    private static final String SE_DEBE_INGRESAR_CANTIDAD_CONSIGNADA_EN_EL_RANGO_VALIDO = "El monto para la consignación no es correcto";

    private static final BigDecimal CANTIDAD_MINIMA_CONSIGNACION = new BigDecimal(1000);
    private static final BigDecimal CANTIDAD_MAXIMA_CONSIGNACION = new BigDecimal(1000000);

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String identificacion;
    private BigDecimal cantidadConsignada;

    public Consignacion(Long id, String nombre, String apellido, String telefono, String direccion, String identificacion, BigDecimal cantidadConsignada) {

        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_INGRESAR_NOMBRE);
        ValidadorArgumento.validarObligatorio(apellido,SE_DEBE_INGRESAR_APELLIDO);
        ValidadorArgumento.validarObligatorio(telefono,SE_DEBE_INGRESAR_TELEFONO);
        ValidadorArgumento.validarObligatorio(direccion, SE_DEBE_INGRESAR_DIRECCION);
        ValidadorArgumento.validarObligatorio(identificacion,SE_DEBE_INGRESAR_IDENTIFICACION);
        ValidadorArgumento.validarObligatorio(cantidadConsignada,SE_DEBE_INGRESAR_CANTIDAD_CONSIGNADA);
        ValidadorArgumento.validarCantidadConsignada(cantidadConsignada,CANTIDAD_MAXIMA_CONSIGNACION,CANTIDAD_MINIMA_CONSIGNACION,SE_DEBE_INGRESAR_CANTIDAD_CONSIGNADA_EN_EL_RANGO_VALIDO);

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.cantidadConsignada = cantidadConsignada;
    }

    public void setCantidadConsignada(BigDecimal cantidadConsignada){
        this.cantidadConsignada = cantidadConsignada;
    }

}
