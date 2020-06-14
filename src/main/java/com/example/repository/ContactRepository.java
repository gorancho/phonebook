package com.example.repository;

import com.example.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends CrudRepository<Contact, String> {
    Contact findByName(@Param("name") String name);
}
