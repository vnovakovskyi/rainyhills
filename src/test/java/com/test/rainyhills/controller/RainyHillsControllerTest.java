package com.test.rainyhills.controller;

import com.test.rainyhills.service.WaterValueCounterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class RainyHillsControllerTest {

    @Mock
    WaterValueCounterService service;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(
                        new RainyHillsController(service))
                .build();
    }

    @Test
    void test_calculateWaterValue_success() throws Exception {
        int[] surface = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        String path = "/watervalue/" + "0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1";
        Mockito.when(service.count(surface))
                .thenReturn(6);

        mockMvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void test_calculateWaterValue_failed() throws Exception {
        int[] surface = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        String path = "/watervalue/" + Arrays.toString(surface);
        mockMvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
