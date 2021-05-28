package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Consignacion;

public interface RepositorioPersona {

    /**
     * Permite crear un usuario
     * @param consignacion
     * @return el id generado
     */
    Long crear(Consignacion consignacion);

    /**
     * Permite actualizar un usuario
     * @param consignacion
     */
    void actualizar(Consignacion consignacion);

    /**
     * Permite eliminar un persona
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un cedula
     * @param cedula
     * @return si existe o no
     */
    boolean existe(String cedula);

}
