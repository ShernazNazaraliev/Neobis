package com.example.AutoShop;

import com.example.AutoShop.Entity.PriceList;
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
public class PriceListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPriceListTest() throws  Exception{
        this.mockMvc.perform(get("/priceList"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOnePriceTest() throws  Exception{
        this.mockMvc.perform(get("/priceList/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postPriceTest() throws Exception {
        PriceList price = new PriceList();
        price.setPriceID(6L);
        price.setPrice(60000);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(price);
        mockMvc.perform(post("/priceList").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putPriceTest() throws  Exception{
        PriceList price = new PriceList();
        price.setPrice(65000);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(price);
        mockMvc.perform(put("/priceList/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deletePriceTest() throws  Exception{
        this.mockMvc.perform(delete("/priceList/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
