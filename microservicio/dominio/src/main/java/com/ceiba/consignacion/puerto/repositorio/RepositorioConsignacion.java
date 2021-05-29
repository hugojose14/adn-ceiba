package com.ceiba.consignacion.puerto.repositorio;

import com.ceiba.consignacion.modelo.entidad.Consignacion;


public interface RepositorioConsignacion {

    /**
     * Permite crear un consignacion
     * @param consignacion
     * @return el id generado
     */
    Long crear(Consignacion consignacion);

    /**
     * Permite actualizar un consignacion
     * @param consignacion
     */
    void actualizar(Consignacion consignacion);

    /**
     * Permite eliminar un consignacion
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un cedula
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

}
