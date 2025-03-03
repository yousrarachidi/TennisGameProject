package com.example.tennis.controller;

import com.example.tennis.service.TennisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TennisControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TennisService tennisService;

    @InjectMocks
    private TennisController tennisController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tennisController).build();
    }

    @Test
    void testGetScore() throws Exception {
        when(tennisService.getScore()).thenReturn("0 - 0");

        mockMvc.perform(get("/tennis/score"))
                .andExpect(status().isOk())
                .andExpect(content().string("0 - 0"));

        verify(tennisService, times(1)).getScore();
    }

    @Test
    void testPointWonByPlayer1() throws Exception {
        when(tennisService.getScore()).thenReturn("15 - 0");

        mockMvc.perform(post("/tennis/point/Player 1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("15 - 0"));

        verify(tennisService, times(1)).pointWonBy("Player 1");
        verify(tennisService, times(1)).getScore();
    }

    @Test
    void testPointWonByPlayer2() throws Exception {
        when(tennisService.getScore()).thenReturn("0 - 15");

        mockMvc.perform(post("/tennis/point/Player 2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("0 - 15"));

        verify(tennisService, times(1)).pointWonBy("Player 2");
        verify(tennisService, times(1)).getScore();
    }
}
