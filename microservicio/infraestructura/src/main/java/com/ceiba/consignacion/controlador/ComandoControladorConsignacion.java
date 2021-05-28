package com.ceiba.consignacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoPersona;
import com.ceiba.usuario.comando.manejador.ManejadorCrearPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consignacion")
@Api(tags = {"controlador para las consignaciones de las personas"})
public class ComandoControladorPersona {

    private final ManejadorCrearPersona manejadorCrearPersona;

    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona){
        this.manejadorCrearPersona = manejadorCrearPersona;
    }

    @PostMapping
    @ApiOperation("Crear consignaciones")
    public ComandoRespuesta<Long>  crear(@RequestBody ComandoPersona comandoPersona){
        return manejadorCrearPersona.ejecutar(comandoPersona);
    }

}
