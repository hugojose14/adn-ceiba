package com.ceiba.consignacion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.consignacion.comando.ComandoConsignacion;
import com.ceiba.consignacion.comando.fabrica.FabricaConsignacion;
import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.servicio.ServicioCrearConsignacion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearConsignacion implements ManejadorComandoRespuesta<ComandoConsignacion, ComandoRespuesta<Long>> {

    private final FabricaConsignacion fabricaConsignacion;
    private final ServicioCrearConsignacion servicioCrearConsignacion;

    public ManejadorCrearConsignacion(FabricaConsignacion fabricaConsignacion, ServicioCrearConsignacion servicioCrearConsignacion){
        this.fabricaConsignacion = fabricaConsignacion;
        this.servicioCrearConsignacion = servicioCrearConsignacion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoConsignacion comandoConsignacion){
        Consignacion consignacion = this.fabricaConsignacion.crear(comandoConsignacion);
        return new ComandoRespuesta<>(this.servicioCrearConsignacion.ejecutar(consignacion));
    }


}
