package com.ceiba.consignacion.controlador;

import com.ceiba.consignacion.consulta.ManejadorListarConsignaciones;
import com.ceiba.consignacion.modelo.dto.DtoConsignacion;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consignaciones")
@Api(tags = {"Controlador para la consulta de las consignaciones"})
public class ConsultaControladorConsignacion {

    private final ManejadorListarConsignaciones manejadorListarConsignaciones;

    public ConsultaControladorConsignacion( ManejadorListarConsignaciones manejadorListarConsignaciones){
        this.manejadorListarConsignaciones = manejadorListarConsignaciones;
    }

    @GetMapping
    public List<DtoConsignacion> listar(){
        return this.manejadorListarConsignaciones.ejecutar();
    }

}
