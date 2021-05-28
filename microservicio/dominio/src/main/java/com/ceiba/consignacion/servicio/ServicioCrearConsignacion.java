package com.ceiba.consignacion.servicio;

import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearConsignacion {

    private final RepositorioConsignacion repositorioConsignacion;

    private static final String LA_CONSIGNACION_YA_EXISTE_EN_EL_SISTEMA = "La consignacion ya existe en el sistema";

    public ServicioCrearConsignacion(RepositorioConsignacion repositorioConsignacion){
        this.repositorioConsignacion = repositorioConsignacion;
    }

    public Long ejecutar(Consignacion consignacion){
        validarExisteciaPrevia(consignacion);
        return this.repositorioConsignacion.crear(consignacion);
    }

    private void validarExisteciaPrevia(Consignacion consignacion){
        if(this.repositorioConsignacion.existe(consignacion.getId()))
        {
            throw new ExcepcionDuplicidad(LA_CONSIGNACION_YA_EXISTE_EN_EL_SISTEMA);
        }

    }

}
