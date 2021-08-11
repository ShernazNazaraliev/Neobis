package com.example.AutoShop;

import com.example.AutoShop.Entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOrdersTest() throws  Exception{
        this.mockMvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOrdersByCustomerTest() throws  Exception{
        this.mockMvc.perform(get("/orders/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postOrderByCustomerTest() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setCustomerId(new Customer(1L,"Shernaz","shernaz@gmail","Bishkek","0700700700"));
        order.setStatus("Ready");
        order.setCarId(new Car(1L, "Mercedes", "Black", new CarType(1L,"Sedan"),new PriceList(1L,10000)));
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(order);
        mockMvc.perform(post("/orders/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteOrderTest() throws  Exception{
        this.mockMvc.perform(delete("/orders/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
