package com.example.AutoShop;

import com.example.AutoShop.Entity.*;
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
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    public OrderControllerTest() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getAllOrderCustomers() throws Exception {
        this.mockMvc.perform(get("/customer/{customerId}",1)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOneOrderCustomers() throws Exception {
        this.mockMvc.perform(get("/customer/{customerId}/oder/1",1)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception{
        Order order = new Order(1L,new Customer(1L,"first","first@gmail.com","Moscow","+996704545454"),new Car(1L, "BMW", "black", new CarType(1L, "sedan"), new PriceList(1L, 23000.0)));
        String jsonRequest = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/customer/{customerId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update()throws Exception {
        Order order = new Order(1L,new Customer(1L,"first","first@gmail.com","Moscow","+996704545454"),new Car(1L, "BMW", "black", new CarType(1L, "sedan"), new PriceList(1L, 23000.0)));
        String jsonRequest = objectMapper.writeValueAsString(order);
        mockMvc.perform(MockMvcRequestBuilders.put("/customer/{customerId}/order/1",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception{
        this.mockMvc.perform(delete("/customer/{customerId}/order/1",1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
