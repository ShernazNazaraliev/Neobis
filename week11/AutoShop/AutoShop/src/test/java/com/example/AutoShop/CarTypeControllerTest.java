package com.example.AutoShop;

import com.example.AutoShop.Entity.CarType;
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
public class CarTypeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCarTypeTest() throws  Exception{
        this.mockMvc.perform(get("/carType"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getOneCarTypeTest() throws  Exception{
        this.mockMvc.perform(get("/carType/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postCarTypeTest() throws Exception {
        CarType carType = new CarType();
        carType.setId(8L);
        carType.setCarType("Bus");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(carType);
        mockMvc.perform(post("/carType").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putCarTypeTest() throws  Exception{
        CarType carType = new CarType();
        carType.setCarType("Coupe");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(carType);
        mockMvc.perform(put("/carType/8").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCarTypeTest() throws  Exception{
        this.mockMvc.perform(delete("/carType/8"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
