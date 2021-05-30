package com.ceiba.consignacion.comando.manejador;

import com.ceiba.consignacion.comando.ComandoConsignacion;
import com.ceiba.consignacion.comando.fabrica.FabricaConsignacion;
import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.servicio.ServicioActualizarConsignacion;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarConsignacion implements ManejadorComando<ComandoConsignacion> {

    private final FabricaConsignacion fabricaConsignacion;
    private final ServicioActualizarConsignacion servicioActualizarConsignacion;

    public ManejadorActualizarConsignacion(FabricaConsignacion fabricaConsignacion,
                                           ServicioActualizarConsignacion servicioActualizarConsignacion){
        this.fabricaConsignacion = fabricaConsignacion;
        this.servicioActualizarConsignacion = servicioActualizarConsignacion;
    }

    @Override
    public void ejecutar(ComandoConsignacion comandoConsignacion) {
        Consignacion consignacion = this.fabricaConsignacion.crear(comandoConsignacion);
        this.servicioActualizarConsignacion.ejecutar(consignacion);
    }
}
