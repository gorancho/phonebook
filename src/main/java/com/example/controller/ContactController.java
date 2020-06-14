package com.example.controller;

import com.example.model.Contact;
import com.example.model.ContactResponse;
import com.example.service.ContactService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Log4j2
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(value = "/phoneBook/contact")
    public ContactResponse createContact(@Valid @RequestBody Contact contact) {
        log.debug("Calling createContact : " + contact.toString());
        return contactService.createContact(contact);
    }
}
