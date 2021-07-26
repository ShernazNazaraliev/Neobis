package com.example.AutoShop;

import com.example.AutoShop.Entity.Car;
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
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    public CarControllerTest() {
        objectMapper = new ObjectMapper();
    }
    @Test
    public void getAllTest() throws Exception {
        this.mockMvc.perform(get("/cars")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        this.mockMvc.perform(get("/cars/{id}",1)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception{
        Car car = new Car(1L,"Mercedes", "white",new CarType(1L, "sedan"),new PriceList(1L,23000.0));
        String jsonRequest = objectMapper.writeValueAsString(car);
        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void update()throws Exception {
        Car car = new Car(1L, "BMW", "black", new CarType(1L, "sedan"), new PriceList(1L, 23000.0));
        String jsonRequest = objectMapper.writeValueAsString(car);
        mockMvc.perform(MockMvcRequestBuilders.put("/cars/{id}",2)
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception{
        this.mockMvc.perform(delete("/cars/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
