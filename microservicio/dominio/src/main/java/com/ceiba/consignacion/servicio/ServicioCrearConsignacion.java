package com.ceiba.consignacion.servicio;

import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;

public class ServicioCrearConsignacion {

    private final RepositorioConsignacion repositorioConsignacion;

    public ServicioCrearConsignacion(RepositorioConsignacion repositorioConsignacion){
        this.repositorioConsignacion = repositorioConsignacion;
    }

    public Long ejecutar(Consignacion consignacion){
        return this.repositorioConsignacion.crear(consignacion);
    }


}
