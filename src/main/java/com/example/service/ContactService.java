package com.example.service;

import com.example.model.Contact;
import com.example.model.ContactResponse;

public interface ContactService {
    ContactResponse createContact(Contact contact);
}
