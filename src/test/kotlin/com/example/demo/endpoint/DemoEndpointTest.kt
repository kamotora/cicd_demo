package com.example.demo.endpoint

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class DemoEndpointTest {

    @Autowired
    private var mockMvc: MockMvc? = null

    @Test
    fun testUnauthorized() {
        this.mockMvc!!.get("/demo").andExpect {
            status {
                is3xxRedirection()
            }
        }
    }
}