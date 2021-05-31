package com.ceiba.consignacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import com.ceiba.consignacion.servicio.testdatabuilder.ConsignacionTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;


public class ServicioCrearConsignacionTest {

    @Test
    public void validarConsignacionExistenciaPreviaTest() {
        // arrange
        Consignacion consignacion = new ConsignacionTestDataBuilder().build();
        RepositorioConsignacion repositorioConsignacion = Mockito.mock(RepositorioConsignacion.class);
        Mockito.when(repositorioConsignacion.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearConsignacion servicioCrearConsignacion = new ServicioCrearConsignacion(repositorioConsignacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearConsignacion.ejecutar(consignacion), ExcepcionDuplicidad.class,"La consignacion ya existe en el sistema");
    }

    @Test
    public void crear(){
        // arrange
        Consignacion consignacion = new ConsignacionTestDataBuilder().build();
        RepositorioConsignacion repositorioConsignacion = Mockito.mock(RepositorioConsignacion.class);
        Mockito.when(repositorioConsignacion.crear(consignacion)).thenReturn(1L);
        ServicioCrearConsignacion servicioCrearConsignacion = new ServicioCrearConsignacion(repositorioConsignacion);
        Long id  = servicioCrearConsignacion.ejecutar(consignacion);
        // act - assert
        Assertions.assertEquals(id, new Long(1L));
    }



    @Test
    public void validarCampoNombre() {
        // arrange
        ConsignacionTestDataBuilder consignacionTestDataBuilder = new ConsignacionTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(consignacionTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre");
    }

    @Test
    public void validarCampoApellido() {
        // arrange
        ConsignacionTestDataBuilder consignacionTestDataBuilder = new ConsignacionTestDataBuilder().conApellido(null);
        // act - assert
        BasePrueba.assertThrows(consignacionTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el apellido");
    }

    @Test
    public void validarCampoTelefono() {
        // arrange
        ConsignacionTestDataBuilder consignacionTestDataBuilder = new ConsignacionTestDataBuilder().conTelefono(null);
        // act - assert
        BasePrueba.assertThrows(consignacionTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el teléfono");
    }

    @Test
    public void validarCampoIdentificacion() {
        // arrange
        ConsignacionTestDataBuilder consignacionTestDataBuilder = new ConsignacionTestDataBuilder().conIdentificacion(null);
        // act - assert
        BasePrueba.assertThrows(consignacionTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la identificación");
    }

    @Test
    public void validarCampoCantidadConsignada() {
        // arrange
        ConsignacionTestDataBuilder consignacionTestDataBuilder = new ConsignacionTestDataBuilder().conCantidadConsignada(null);
        // act - assert
        BasePrueba.assertThrows(consignacionTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad consignada");
    }

    @Test
    public void validarCampoDireccion() {
        // arrange
        ConsignacionTestDataBuilder consignacionTestDataBuilder = new ConsignacionTestDataBuilder().conDireccion(null);
        // act - assert
        BasePrueba.assertThrows(consignacionTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la dirección");
    }


}
