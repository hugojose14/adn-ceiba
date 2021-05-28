package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoConsignacion;
import com.ceiba.usuario.modelo.entidad.Consignacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaConsignacion {

    public Consignacion crear(ComandoConsignacion comandoConsignacion){
        return new Consignacion(
                comandoConsignacion.getId(),
                comandoConsignacion.getNombre(),
                comandoConsignacion.getApellido(),
                comandoConsignacion.getTelefono(),
                comandoConsignacion.getDireccion(),
                comandoConsignacion.getIdentificacion(),
                comandoConsignacion.getCantidadConsignada());
    }
}
