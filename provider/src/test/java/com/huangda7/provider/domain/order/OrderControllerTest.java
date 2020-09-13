package com.huangda7.provider.domain.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderController.class)
@AutoConfigureJsonTesters
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JacksonTester<List<OrderBriefInfoDTO>> orderBriefInfoDTOJacksonTester;

    @Test
    void should_return_200_and_bl_brief_info_when_getBLBriefInfo_given_voyage_stop_and_support_offices() throws Exception {
        //given
        String dateTime = "20200913";
        OrderBriefInfoDTO expectOrderBriefInfoDTO = OrderBriefInfoDTO.builder()
                .orderId(1000000004436176400L)
                .orderNum("9930448990222")
                .orderStatus("started")
                .build();
        //when
        String response = mockMvc.perform(get("/order/order-brief-info?dateTime=" + dateTime)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        //post
//        String response = mockMvc.perform(post("/order-update")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(String.valueOf(1L)))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
        //then
        List<OrderBriefInfoDTO> actualBLBriefInfoDTOs = orderBriefInfoDTOJacksonTester.parse(response).getObject();
        assertAll(
                () -> assertThat(actualBLBriefInfoDTOs.size()).isEqualTo(1),
                () -> assertThat(actualBLBriefInfoDTOs.get(0)).isEqualTo(expectOrderBriefInfoDTO)
        );
    }
}