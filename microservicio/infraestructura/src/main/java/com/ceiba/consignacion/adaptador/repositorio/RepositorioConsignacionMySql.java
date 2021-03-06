package com.ceiba.consignacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.consignacion.modelo.entidad.Consignacion;
import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioConsignacionMySql implements RepositorioConsignacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="consignacion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "consignacion", value ="existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "consignacion", value ="actualizar")
    private static String sqlActualizar;

    public RepositorioConsignacionMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Consignacion consignacion) {
        return this.customNamedParameterJdbcTemplate.crear(consignacion,sqlCrear);
    }

    @Override
    public void actualizar(Consignacion consignacion) {
        this.customNamedParameterJdbcTemplate.actualizar(consignacion, sqlActualizar);

    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,parameterSource, Boolean.class);
    }


}
