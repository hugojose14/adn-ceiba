package com.ceiba.consignacion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.consignacion.consulta.ManejadorListarConsignaciones;
import com.ceiba.consignacion.modelo.dto.DtoConsignacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorConsignacion.class)
public class ConsultaControllerConsignacionTest {

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ManejadorListarConsignaciones manejadorListarConsignaciones;

    private DtoConsignacion dtoConsignacion;

    private List<DtoConsignacion> dtoConsignacionList;

    @Test
    public void listar() throws Exception {

        dtoConsignacion = new DtoConsignacion(1L, "Hugo",
                "Pérez",
                "3054705359", "Barrio españa", "1001896753",
                new BigDecimal(10000));

        dtoConsignacionList = Arrays.asList(dtoConsignacion);

        when(manejadorListarConsignaciones.ejecutar()).thenReturn(dtoConsignacionList);
        mocMvc.perform(get("/consignaciones"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"nombre\": \"Hugo\",\n" +
                        "    \"apellido\": \"Pérez\",\n" +
                        "    \"telefono\": \"3054705359\",\n" +
                        "    \"direccion\": \"Barrio españa\",\n" +
                        "    \"identificacion\": \"1001896753\",\n" +
                        "    \"cantidadConsignada\": 10000\n" +
                        "  }\n" +
                        "]"));
    }

}
