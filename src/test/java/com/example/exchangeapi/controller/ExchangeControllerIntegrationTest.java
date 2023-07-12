package com.example.exchangeapi.controller;

import com.example.exchangeapi.model.Query;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void convertIntegrationTest() throws Exception {
        Query query = new Query();
        query.setFrom("USD");
        query.setTo("EUR");
        query.setAmount(100.00);

        ObjectMapper objectMapper = new ObjectMapper();
        String queryJson = objectMapper.writeValueAsString(query);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/exchange/convert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(queryJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.query.from").value("USD"))
                .andExpect(jsonPath("$.query.to").value("EUR"))
                .andExpect(jsonPath("$.query.amount").value(100.00));
    }
}
