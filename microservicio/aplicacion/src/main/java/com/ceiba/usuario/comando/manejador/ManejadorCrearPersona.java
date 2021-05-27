package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoPersona;
import com.ceiba.usuario.comando.fabrica.FabricaPersona;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.servicio.ServicioCrearPersonas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoPersona, ComandoRespuesta<Long>> {

    private final FabricaPersona fabricaPersona;
    private final ServicioCrearPersonas servicioCrearPersonas;

    public ManejadorCrearPersona(FabricaPersona fabricaPersona,ServicioCrearPersonas servicioCrearPersonas){
        this.fabricaPersona = fabricaPersona;
        this.servicioCrearPersonas = servicioCrearPersonas;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPersona comandoPersona){
        Persona persona = this.fabricaPersona.crear(comandoPersona);
        return new ComandoRespuesta<>(this.servicioCrearPersonas.ejecutar(persona));
    }
}
