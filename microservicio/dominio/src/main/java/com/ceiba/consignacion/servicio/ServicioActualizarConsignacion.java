package com.ceiba.consignacion.servicio;

import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import com.ceiba.dominio.excepcion.ExcepcionNoEncontrado;

public class ServicioActualizarConsignacion {

    private static final String LA_CONSIGNACION_EXISTE_EN_EL_SISTEMA = "La consignación no se se encuentra en el sistema";

    private final RepositorioConsignacion repositorioConsignacion;

    public ServicioActualizarConsignacion(RepositorioConsignacion repositorioConsignacion){
        this.repositorioConsignacion = repositorioConsignacion;
    }

    public void ejecutar(Consignacion consignacion){
        validarExisteciaPrevia(consignacion);
        this.repositorioConsignacion.actualizar(consignacion);
    }

    private void validarExisteciaPrevia(Consignacion consignacion){
        if(!this.repositorioConsignacion.existe(consignacion.getId()))
        {
            throw new ExcepcionNoEncontrado(LA_CONSIGNACION_EXISTE_EN_EL_SISTEMA);
        }

    }

}
