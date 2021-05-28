package com.ceiba.consignacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Consignacion;
import com.ceiba.usuario.puerto.repositorio.RepositorioConsignacion;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaMySql implements RepositorioConsignacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="consignacion", value="crear")
    private static String sqlCrear;

    public RepositorioPersonaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Consignacion consignacion) {
        return this.customNamedParameterJdbcTemplate.crear(consignacion,sqlCrear);
    }

    @Override
    public void actualizar(Consignacion persona) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String cedula) {
        return false;
    }
}
