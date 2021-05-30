package com.ceiba.consignacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import com.ceiba.consignacion.servicio.testdatabuilder.ConsignacionTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarConsignacionTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Consignacion consignacion = new ConsignacionTestDataBuilder().conId(1L).build();
        RepositorioConsignacion repositorioConsignacion = Mockito.mock(RepositorioConsignacion.class);
        Mockito.when(repositorioConsignacion.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarConsignacion servicioActualizarConsignacion = new ServicioActualizarConsignacion(repositorioConsignacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarConsignacion.ejecutar(consignacion), ExcepcionDuplicidad.class,"La consignación ya existe en el sistema");
    }
}
