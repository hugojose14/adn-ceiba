package com.ceiba.consignacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import com.ceiba.consignacion.servicio.testdatabuilder.ConsignacionTestDataBuilder;

import com.ceiba.dominio.excepcion.ExcepcionNoEncontrado;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarConsignacionTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Consignacion consignacion = new ConsignacionTestDataBuilder().conId(1L).build();
        RepositorioConsignacion repositorioConsignacion = Mockito.mock(RepositorioConsignacion.class);
        Mockito.when(repositorioConsignacion.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarConsignacion servicioActualizarConsignacion = new ServicioActualizarConsignacion(repositorioConsignacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarConsignacion.ejecutar(consignacion), ExcepcionNoEncontrado.class,"La consignación no se se encuentra en el sistema");
    }

    @Test
    public void actualizar(){
        // arrange
        Consignacion consignacion = new ConsignacionTestDataBuilder().conId(1L).build();
        RepositorioConsignacion repositorioConsignacion = Mockito.mock(RepositorioConsignacion.class);
        Mockito.when(repositorioConsignacion.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarConsignacion servicioActualizarConsignacion = new ServicioActualizarConsignacion(repositorioConsignacion);
        servicioActualizarConsignacion.ejecutar(consignacion);
        // act - assert
        Mockito.verify(repositorioConsignacion,Mockito.times(1)).actualizar(consignacion);
    }


}
