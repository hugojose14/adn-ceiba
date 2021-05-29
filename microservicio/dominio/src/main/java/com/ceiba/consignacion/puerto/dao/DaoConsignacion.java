package com.ceiba.consignacion.puerto.dao;

import com.ceiba.consignacion.modelo.dto.DtoConsignacion;

import java.util.List;

public interface DaoConsignacion {

    /**
     * Permite listar consignaciones
     * @return las consignaciones
     */
    List<DtoConsignacion> listar();

}
