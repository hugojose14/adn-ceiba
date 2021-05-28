package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Consignacion;
import com.ceiba.usuario.puerto.repositorio.RepositorioConsignacion;

public class ServicioCrearConsignacion {

    private final RepositorioConsignacion repositorioConsignacion;

    public ServicioCrearConsignacion(RepositorioConsignacion repositorioConsignacion){
        this.repositorioConsignacion = repositorioConsignacion;
    }

    public Long ejecutar(Consignacion consignacion){
        return this.repositorioConsignacion.crear(consignacion);
    }


}
