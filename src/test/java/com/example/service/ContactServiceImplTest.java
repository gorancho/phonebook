package com.example.service;

import com.example.model.Contact;
import com.example.model.ContactResponse;
import com.example.repository.ContactRepository;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceImplTest {

    @InjectMocks
    ContactServiceImpl contactServiceImpl;

    @Mock
    ContactRepository contactRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public final void testCreateContact() {
        Contact contact = new Contact("1", "goran", "+38975603539");
        when(contactRepository.save(contact)).thenReturn(contact);
        ContactResponse createdContact = contactServiceImpl.createContact(contact);
        assertEquals(contact.getId(), createdContact.getId());
        verify(contactRepository, times(1)).save(any());
    }

    @Test
    public void testCreateContactNameNotBlank() {
        Contact contact = new Contact("1", "", "+38975603539");
        Set<ConstraintViolation<Contact>> constraintViolations =
                validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("must not be blank", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testCreateContactPhoneNumberNotBlank() {
        Contact contact = new Contact("1", "goran", null);
        Set<ConstraintViolation<Contact>> constraintViolations =
                validator.validate(contact);
        assertEquals("must not be blank", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testCreateContactPhoneNumberInvalidFormat() {
        Contact contact = new Contact("1", "goran", "+38975asd539");
        Set<ConstraintViolation<Contact>> constraintViolations =
                validator.validate(contact);
        assertEquals(1, constraintViolations.size());
        assertEquals("invalid format", constraintViolations.iterator().next().getMessage());
    }
}
