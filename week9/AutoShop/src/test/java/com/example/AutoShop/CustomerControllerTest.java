package com.example.AutoShop;

import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Entity.Customer;
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
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    public CustomerControllerTest() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getAllTest() throws Exception {
        this.mockMvc.perform(get("/customer")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        this.mockMvc.perform(get("/customer/{id}",1)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception{
        Customer customer = new Customer(1L,"second","second@gmail.com","Bishkek","+996704545454");
        String jsonRequest = objectMapper.writeValueAsString(customer);
        mockMvc.perform(post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update()throws Exception {
        Customer customer = new Customer(1L,"first","first@gmail.com","Moscow","+996704545454");
        String jsonRequest = objectMapper.writeValueAsString(customer);
        mockMvc.perform(MockMvcRequestBuilders.put("/customer/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception{
        this.mockMvc.perform(delete("/customer/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
