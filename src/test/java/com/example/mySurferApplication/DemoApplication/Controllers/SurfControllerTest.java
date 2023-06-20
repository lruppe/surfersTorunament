package com.example.mySurferApplication.DemoApplication.Controllers;

import com.example.mySurferApplication.DemoApplication.Services.ContestService;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import com.example.mySurferApplication.DemoApplication.Services.Entities.SurferDto;
import com.example.mySurferApplication.DemoApplication.Services.SurferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest
class SurfControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContestService mockedContestService;

    @MockBean
    private SurferService mockedSurferService;


    @Test
    void whenGetContest_shoudReturnContest() throws Exception{
        when(mockedContestService.getContest(any())).thenReturn(new Contest("Luzern", 3));

        mockMvc.perform(MockMvcRequestBuilders.get("/1/contest"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.place").value("Luzern"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.maxNrOfSurfer").value(3));
    }

    @Test
    void whenPostSurfer_shouldCreateSurfer() throws Exception {
        mockMvc
                .perform(
                    post("/surfer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\" : \"leon\", \"country\" : \"swiss\", \"gender\" : \"f\"}"));

        verify(mockedSurferService).createSurfer(any(SurferDto.class));
    }
}