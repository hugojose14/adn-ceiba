package com.ceiba.consignacion.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorConsignacion.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConsultaControllerConsignacionTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @Ignore
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void listar() throws Exception {

        mocMvc.perform(get("/consignaciones"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"nombre\": \"Hugo\",\n" +
                        "    \"apellido\": \"Pérez\",\n" +
                        "    \"telefono\": \"3054705359\",\n" +
                        "    \"direccion\": \"Cartagena\",\n" +
                        "    \"identificacion\": \"123456789\",\n" +
                        "    \"cantidadConsignada\": 9900.0000\n" +
                        "  }\n" +
                        "]"));
    }

}
