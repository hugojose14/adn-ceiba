package com.ceiba.dominio.excepcion;

public class ExcepcionConsignacionValorRango extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionConsignacionValorRango(String message){
        super(message);
    }

}
