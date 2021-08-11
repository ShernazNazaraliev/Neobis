package com.example.AutoShop;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Entity.CarType;
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
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCarsTest() throws  Exception{
        this.mockMvc.perform(get("/cars"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOneCarTest() throws  Exception{
        this.mockMvc.perform(get("/cars/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void postCarsTest() throws Exception {
        Car car = new Car();
        car.setId(1L);
        car.setPriceListId(new PriceList(1L,10000));
        car.setCarName("BMW");
        car.setCarTypeId(new CarType(1L,"Sedan"));
        car.setColor("White");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(car);
        mockMvc.perform(post("/cars").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putCarsTest() throws  Exception{
        Car car = new Car();
        car.setId(1L);
        car.setPriceListId(new PriceList(2L,20000));
        car.setCarName("Volvo");
        car.setCarTypeId(new CarType(5L,"Coupe"));
        car.setColor("Black");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(car);
        mockMvc.perform(put("/cars/1").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCarsTest() throws  Exception{

        this.mockMvc.perform(delete("/cars/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
