package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoConsignacion;
import com.ceiba.usuario.modelo.entidad.Consignacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {

    public Consignacion crear(ComandoConsignacion comandoPersona){
        return new Consignacion(
                comandoPersona.getId(),
                comandoPersona.getNombre(),
                comandoPersona.getApellido(),
                comandoPersona.getTelefono(),
                comandoPersona.getDireccion(),
                comandoPersona.getIdentificacion(),
                comandoPersona.getCantidadConsignada());
    }
}
