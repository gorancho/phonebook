package com.example.controller;

import com.example.model.Contact;
import com.example.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactController contactController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(contactController).isNotNull();
    }

    @Test
    public void registrationWorksThroughAllLayers() throws Exception {
        Contact contact = new Contact(null, "Goran", "+38975603539");
        mockMvc.perform(post("/phoneBook/contact")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(contact)))
                .andExpect(status().isOk());
        Contact savedContact = contactRepository.findByName("Goran");
        assertThat(savedContact.getPhoneNumber()).isEqualTo("+38975603539");
    }

}
