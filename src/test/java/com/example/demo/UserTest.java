package com.example.demo;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@Transactional
class UserTest extends TestBase{

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository repository;

    @Test
    public void testGetAll() throws Exception {

        this.mvc.perform(get("/api/v1/user/public"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.content", hasSize(20)));
    }

    @Test
    public void testGetAllEvents() throws Exception {

        this.mvc.perform(get("/api/v1/user/public/participating/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").doesNotExist());
    }

    /*@Test
    public void testGetOne() throws Exception {

        this.mvc.perform(get("/api/v1/user/public/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.content", hasSize(1)));
    }*/

    @Test
    public void testFindByUsername() throws Exception {
        final User found = this.repository.findByUsername("admin");

        assertEquals("admin", found.getUsername());
    }
}
