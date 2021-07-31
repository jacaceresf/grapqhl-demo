package com.jacaceresf.graphqldemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GraphqlDemoApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void listFoods() throws Exception {

        String expectedResponse = "{\"data\":{\"foods\":[" +
                "{\"id\":1,\"name\":\"Pizza\",\"isGood\":true}," +
                "{\"id\":2,\"name\":\"Spam\",\"isGood\":false}," +
                "{\"id\":3,\"name\":\"Eggs\",\"isGood\":true}," +
                "{\"id\":4,\"name\":\"Avocado\",\"isGood\":false}," +
                "{\"id\":5,\"name\":\"Burger\",\"isGood\":true}" +
                "]}}";

        mockMvc.perform(MockMvcRequestBuilders.post("/graphql")
                .content("{\"query\":\"{ foods { id name isGood } }\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse))
                .andReturn();
    }

    @Test
    void saveFood() throws Exception {
        String expectedResponse = "{\n" +
                "  \"data\": {\n" +
                "    \"saveFood\": {\n" +
                "      \"id\": 6,\n" +
                "      \"isGood\": true,\n" +
                "      \"name\": \"Pasta\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/graphql")
                .content("mutation {\n" +
                        "  saveFood(food: {name: \"Pasta\"}){\n" +
                        "    id\n" +
                        "    isGood\n" +
                        "    name\n" +
                        "  }\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse))
                .andReturn();
    }

}
