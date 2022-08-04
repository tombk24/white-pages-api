package com.borthwick.whitepagesapplication.controller;

import com.borthwick.whitepagesapplication.service.WhitePagesService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WhitePagesControllerTest {

    private static final String PHONE_ENDPOINT = "API/v1/whitePages/phone";

    @MockBean
    private WhitePagesService mockWhitePagesService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void givenValidRequest_WhenPhoneEndpointCalled_ThenReturnSuccess(){
        var expectedResult = "0123456789";

        Mockito.when(mockWhitePagesService.getPhoneNumber("Jim")).thenReturn(expectedResult);

        this.mockMvc.perform(get(PHONE_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expectedResult)));

    }

    // given invalid request: return 400
    // given empty return: return 404
    // given exception in whitepagesService: return 500
}
