package com.ceiba.consignacion.consulta;

import com.ceiba.consignacion.modelo.dto.DtoConsignacion;
import com.ceiba.consignacion.puerto.dao.DaoConsignacion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarConsignaciones {

    private final DaoConsignacion daoConsignacion;

    public ManejadorListarConsignaciones(DaoConsignacion daoConsignacion){
        this.daoConsignacion = daoConsignacion;
    }

    public List<DtoConsignacion> ejecutar(){
        return this.daoConsignacion.listar();
    }

}
