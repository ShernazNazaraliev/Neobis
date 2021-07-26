package com.example.AutoShop;

import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Entity.PriceList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    public PriceListControllerTest() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getAllTest() throws Exception {
        this.mockMvc.perform(get("/PriceList")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        this.mockMvc.perform(get("/PriceList/{id}",1)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception{
        PriceList priceList = new PriceList(1L,50000.0);
        String jsonRequest = objectMapper.writeValueAsString(priceList);
        mockMvc.perform(post("/PriceList")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update()throws Exception {
        PriceList priceList = new PriceList(1L,50000.0);
        String jsonRequest = objectMapper.writeValueAsString(priceList);
        mockMvc.perform(MockMvcRequestBuilders.put("/PriceList/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception{
        this.mockMvc.perform(delete("/PriceList/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
