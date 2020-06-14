package com.example.service;

import com.example.model.Contact;
import com.example.model.ContactResponse;
import com.example.repository.ContactRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactResponse createContact(Contact contact){
            Contact savedContact = contactRepository.save(contact);
            return buildContactResponse(savedContact);
    }

    private ContactResponse buildContactResponse(Contact contact) {
        return ContactResponse.builder().id(contact.getId()).build();
    }
}
