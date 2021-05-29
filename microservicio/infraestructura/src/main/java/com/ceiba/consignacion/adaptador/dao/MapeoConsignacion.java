package com.ceiba.consignacion.adaptador.dao;

import com.ceiba.consignacion.modelo.dto.DtoConsignacion;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoConsignacion implements RowMapper<DtoConsignacion>, MapperResult {

    @Override
    public DtoConsignacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String telefono = resultSet.getString("telefono");
        String direccion = resultSet.getString("direccion");
        String identificacion = resultSet.getString("identificacion");
        BigDecimal cantidadConsignada = resultSet.getBigDecimal("cantidadconsignada");
        return new DtoConsignacion(id,nombre,apellido,telefono,direccion,identificacion,cantidadConsignada);
    }
}
