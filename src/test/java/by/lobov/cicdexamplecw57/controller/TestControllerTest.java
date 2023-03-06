package by.lobov.cicdexamplecw57.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test"))//хочу протестировать
                // get-метод с адресом /test
                .andDo(MockMvcResultHandlers.print()) //отобрази информацию о результате
                .andExpect(MockMvcResultMatchers.status().isOk()) //проверка статуса того что пришло
                // и что должно (должен прийти 200 ответ - ОК)

                .andExpect(MockMvcResultMatchers.content().string("hello world!"));
        //проверяем что приходит в теле запроса

    }
}