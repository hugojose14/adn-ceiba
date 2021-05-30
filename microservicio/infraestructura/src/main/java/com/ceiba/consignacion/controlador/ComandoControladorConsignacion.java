package com.ceiba.consignacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.consignacion.comando.ComandoConsignacion;
import com.ceiba.consignacion.comando.manejador.ManejadorActualizarConsignacion;
import com.ceiba.consignacion.comando.manejador.ManejadorCrearConsignacion;
import com.ceiba.usuario.comando.ComandoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consignaciones")
@Api(tags = {"controlador para las consignaciones de los usuarios"})
public class ComandoControladorConsignacion {

    private final ManejadorCrearConsignacion manejadorCrearConsignacion;
    private final ManejadorActualizarConsignacion manejadorActualizarConsignacion;

    public ComandoControladorConsignacion(ManejadorCrearConsignacion manejadorCrearConsignacion,
                                          ManejadorActualizarConsignacion manejadorActualizarConsignacion){
        this.manejadorCrearConsignacion = manejadorCrearConsignacion;
        this.manejadorActualizarConsignacion = manejadorActualizarConsignacion;
    }

    @PostMapping
    @ApiOperation("Crear consignaciones")
    public ComandoRespuesta<Long>  crear(@RequestBody ComandoConsignacion comandoConsignacion){
        return manejadorCrearConsignacion.ejecutar(comandoConsignacion);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar consignación")
    public void actualizar(@RequestBody ComandoConsignacion comandoConsignacion, @PathVariable Long id) {
        comandoConsignacion.setId(id);
        manejadorActualizarConsignacion.ejecutar(comandoConsignacion);
    }

}
