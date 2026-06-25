package com.icode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
class StaticSiteTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void indexPageShouldReturn200() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk());
    }

    @Test
    void indexPageShouldContainNav() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("nav")));
    }

    @Test
    void aboutPageShouldReturn200() throws Exception {
        mockMvc.perform(get("/about.html"))
                .andExpect(status().isOk());
    }

    @Test
    void contactPageShouldReturn200() throws Exception {
        mockMvc.perform(get("/contact.html"))
                .andExpect(status().isOk());
    }

    @Test
    void cssFileShouldReturn200() throws Exception {
        mockMvc.perform(get("/css/style.css"))
                .andExpect(status().isOk());
    }

    @Test
    void jsFileShouldReturn200() throws Exception {
        mockMvc.perform(get("/js/app.js"))
                .andExpect(status().isOk());
    }
}