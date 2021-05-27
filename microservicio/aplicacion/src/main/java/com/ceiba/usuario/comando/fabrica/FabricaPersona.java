package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoPersona;
import com.ceiba.usuario.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {

    public Persona crear(ComandoPersona comandoPersona){
        return new Persona(
                comandoPersona.getId(),
                comandoPersona.getNombre(),
                comandoPersona.getApellido(),
                comandoPersona.getTelefono(),
                comandoPersona.getDireccion(),
                comandoPersona.getIdentificacion(),
                comandoPersona.getCantidadConsignada());
    }
}
