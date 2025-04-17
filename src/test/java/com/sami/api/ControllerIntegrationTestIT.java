package com.sami.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPersonnesTest() throws Exception {
        mockMvc.perform(get("/personnes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].personne_nom", is("Jules le M")));
    }

    @Test
    public void getVehiculesTest() throws Exception {
        mockMvc.perform(get("/vehicules"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].vehicule_marque", is("Volkswagen")));
    }
}
