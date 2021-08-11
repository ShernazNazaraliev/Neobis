package com.example.AutoShop;

import com.example.AutoShop.Entity.Customer;
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
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCustomersTest() throws  Exception{
        this.mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneCustomerTest() throws  Exception{
        this.mockMvc.perform(get("/customers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postCustomerTest() throws Exception {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCustomerName("Shernaz");
        customer.setAddress("Bishkek");
        customer.setEmail("shernaz@gmail.com");
        customer.setPhoneNumber("0700700700");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(customer);
        mockMvc.perform(post("/customers").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putCustomerTest() throws  Exception{
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCustomerName("Nazaraliev");
        customer.setAddress("Talas");
        customer.setEmail("Nazaraliev@gmail.com");
        customer.setPhoneNumber("0123456789");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(customer);
        mockMvc.perform(put("/customers/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCustomerTest() throws  Exception{
        this.mockMvc.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
