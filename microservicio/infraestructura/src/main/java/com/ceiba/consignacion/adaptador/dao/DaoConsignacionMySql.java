package com.ceiba.consignacion.adaptador.dao;

import com.ceiba.consignacion.modelo.dto.DtoConsignacion;
import com.ceiba.consignacion.puerto.dao.DaoConsignacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoConsignacionMySql implements DaoConsignacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="consignacion", value="listar")
    private static String sqlListar;

    public DaoConsignacionMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoConsignacion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,new MapeoConsignacion());
    }
}
