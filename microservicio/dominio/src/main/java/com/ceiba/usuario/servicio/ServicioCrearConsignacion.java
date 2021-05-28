package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Consignacion;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersonas {

    private final RepositorioPersona personaRepositorio;

    public ServicioCrearPersonas(RepositorioPersona personaRepositorio){
        this.personaRepositorio = personaRepositorio;
    }

    public Long ejecutar(Consignacion persona){
        return this.personaRepositorio.crear(persona);
    }


}
