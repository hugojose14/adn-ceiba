package com.ceiba.consignacion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.consignacion.comando.ComandoConsignacion;
import com.ceiba.consignacion.servicio.ComandoConsignacionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorConsignacion.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
public class ComandoControllerConsignacionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @Order(1)
    public void crear() throws Exception{
        // arrange
        ComandoConsignacion comandoConsignacion = new ComandoConsignacionTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/consignaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoConsignacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor':1}"));
    }

    @Test
    @Order(2)
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        ComandoConsignacion comandoConsignacion = new ComandoConsignacionTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("consignaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoConsignacion)))
                .andExpect(status().isNotFound());
    }

}
