package com.ceiba.consignacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.consignacion.comando.ComandoConsignacion;
import com.ceiba.consignacion.comando.manejador.ManejadorCrearConsignacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consignaciones")
@Api(tags = {"controlador para las consignaciones de los usuarios"})
public class ComandoControladorConsignacion {

    private final ManejadorCrearConsignacion manejadorCrearConsignacion;

    public ComandoControladorConsignacion(ManejadorCrearConsignacion manejadorCrearConsignacion){
        this.manejadorCrearConsignacion = manejadorCrearConsignacion;
    }

    @PostMapping
    @ApiOperation("Crear consignaciones")
    public ComandoRespuesta<Long>  crear(@RequestBody ComandoConsignacion comandoConsignacion){
        return manejadorCrearConsignacion.ejecutar(comandoConsignacion);
    }

}
