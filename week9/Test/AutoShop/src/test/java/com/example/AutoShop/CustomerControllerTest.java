package com.example.AutoShop;

import com.example.AutoShop.Entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
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
    public void add() throws Exception{
        Customer customer = new Customer("Shernaz","shernaz@gmail.com","Talas","9967923423432");
        String jsonRequest = objectMapper.writeValueAsString(customer);

        mockMvc.perform(post("/customer/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAll() throws Exception{

        mockMvc.perform(get("/customer/all"))
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test
    public void getById() throws Exception{
        mockMvc.perform(get("/customer/search/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void Update() throws Exception{

        Customer customer = new Customer(1L,"ShernazShernaz","shernazshernaz@gmail.com","TalasTalas","99679234234329967923423432");
        String jsonRequest = objectMapper.writeValueAsString(customer);

        mockMvc.perform(put("/customer/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
