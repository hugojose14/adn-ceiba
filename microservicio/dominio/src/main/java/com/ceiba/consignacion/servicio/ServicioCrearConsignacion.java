package com.ceiba.consignacion.servicio;

import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;

public class ServicioCrearConsignacion {

    private final RepositorioConsignacion repositorioConsignacion;

    private static final String LA_CONSIGNACION_YA_EXISTE_EN_EL_SISTEMA = "La consignacion ya existe en el sistema";

    private static final LocalDate FECHA_ACTUAL = LocalDate.now(ZoneId.of("America/Bogota"));

    public ServicioCrearConsignacion(RepositorioConsignacion repositorioConsignacion){
        this.repositorioConsignacion = repositorioConsignacion;
    }

    public Long ejecutar(Consignacion consignacion){
        validarExisteciaPrevia(consignacion);
        calcularDiaSemana(consignacion);
        return this.repositorioConsignacion.crear(consignacion);
    }

    private void validarExisteciaPrevia(Consignacion consignacion){
        if(this.repositorioConsignacion.existe(consignacion.getId()))
        {
            throw new ExcepcionDuplicidad(LA_CONSIGNACION_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void calcularDiaSemana(Consignacion consignacion){
        BigDecimal cantidadExcedente;
        if(FECHA_ACTUAL.getDayOfWeek() == DayOfWeek.SUNDAY
        || FECHA_ACTUAL.getDayOfWeek() == DayOfWeek.SATURDAY){
            cantidadExcedente = calculoCantidadConsignada(consignacion, 0.02);
        }
        else{
            cantidadExcedente = calculoCantidadConsignada(consignacion, 0.01);
        }
        consignacion.setCantidadConsignada(cantidadExcedente);
    }

    private BigDecimal calculoCantidadConsignada(Consignacion consignacion, double porcentajeConsignacion) {
        return (consignacion.getCantidadConsignada()).
                subtract(consignacion.getCantidadConsignada().
                        multiply(BigDecimal.valueOf(porcentajeConsignacion)));
    }

}
