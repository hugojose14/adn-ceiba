package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaMySql implements RepositorioPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="persona", value="crear")
    private static String sqlCrear;

    public RepositorioPersonaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Persona persona) {
        return this.customNamedParameterJdbcTemplate.crear(persona,sqlCrear);
    }

    @Override
    public void actualizar(Persona persona) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String cedula) {
        return false;
    }
}
