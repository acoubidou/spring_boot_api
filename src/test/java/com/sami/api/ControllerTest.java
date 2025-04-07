package com.sami.api;

import com.sami.controller.PersonneController;
import com.sami.service.PersonneService;
import com.sami.controller.VehiculeController;
import com.sami.service.VehiculeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PersonneController.class, VehiculeController.class})
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonneService personneService;

    @MockBean
    private VehiculeService vehiculeService;

    @Test
    public void getPeronnesTest() throws Exception {
        mockMvc.perform(get("/personnes")).andExpect(status().isOk());
    }

    @Test
    public void getVehiculeTest() throws Exception {
        mockMvc.perform(get("/vehicules")).andExpect(status().isOk());
    }
}
