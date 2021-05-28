package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoConsignacion;
import com.ceiba.usuario.comando.fabrica.FabricaConsignacion;
import com.ceiba.usuario.modelo.entidad.Consignacion;
import com.ceiba.usuario.servicio.ServicioCrearConsignacion;
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
