package com.ceiba.consignacion.comando.fabrica;

import com.ceiba.consignacion.comando.ComandoConsignacion;
import com.ceiba.consignacion.modelo.entidad.Consignacion;
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
