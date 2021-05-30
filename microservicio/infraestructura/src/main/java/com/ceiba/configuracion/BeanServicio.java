package com.ceiba.configuracion;

import com.ceiba.consignacion.puerto.repositorio.RepositorioConsignacion;
import com.ceiba.consignacion.servicio.ServicioActualizarConsignacion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.consignacion.servicio.ServicioCrearConsignacion;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearConsignacion servicioCrearPersonas(RepositorioConsignacion repositorioConsignacion){
        return new ServicioCrearConsignacion(repositorioConsignacion);
    }
	@Bean
    public ServicioActualizarConsignacion servicioActualizarConsignacion(RepositorioConsignacion repositorioConsignacion){
        return new ServicioActualizarConsignacion(repositorioConsignacion);
    }

}
