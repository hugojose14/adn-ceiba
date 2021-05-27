package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioPersona {

    /**
     * Permite crear un usuario
     * @param persona
     * @return el id generado
     */
    Long crear(Persona persona);

    /**
     * Permite actualizar un usuario
     * @param persona
     */
    void actualizar(Persona persona);

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
