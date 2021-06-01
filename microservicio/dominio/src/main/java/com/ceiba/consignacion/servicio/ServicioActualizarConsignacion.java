package com.ceiba.consignacion.servicio;

import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionNoEncontrado;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;

public class ServicioActualizarConsignacion {

    private static final String LA_CONSIGNACION_EXISTE_EN_EL_SISTEMA = "La consignación no se se encuentra en el sistema";

    private static final LocalDate FECHA_ACTUAL = LocalDate.now(ZoneId.of("America/Bogota"));

    private final RepositorioConsignacion repositorioConsignacion;

    public ServicioActualizarConsignacion(RepositorioConsignacion repositorioConsignacion){
        this.repositorioConsignacion = repositorioConsignacion;
    }

    public void ejecutar(Consignacion consignacion){
        validarExisteciaPrevia(consignacion);
        this.repositorioConsignacion.actualizar(consignacion);
    }

    private void validarExisteciaPrevia(Consignacion consignacion){
        if(!this.repositorioConsignacion.existe(consignacion.getId()))
        {
            throw new ExcepcionNoEncontrado(LA_CONSIGNACION_EXISTE_EN_EL_SISTEMA);
        }

    }

}
