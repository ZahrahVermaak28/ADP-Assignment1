package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Contact;
import za.ac.cput.repositoryImpl.ContactRepository;
import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryTest {
    private IContactRepository repository;
    private Contact contact;

    @BeforeEach
    void setUp() {
        repository = ContactRepository.getRepository();
        repository.getAll().clear();
        contact = new Contact.Builder().setContactId("C1").setPhoneNumber("0821234567").build();
    }

    @Test
    void create() {
        Contact created = repository.create(contact);
        assertNotNull(created);
        assertEquals("C1", created.getContactId());
    }

    @Test
    void read() {
        repository.create(contact);
        Contact read = repository.read("C1");
        assertNotNull(read);
    }

    @Test
    void update() {
        repository.create(contact);
        Contact updatedContact = new Contact.Builder().setContactId("C1").setPhoneNumber("0719876543").build();
        assertNotNull(repository.update(updatedContact));
        assertEquals("0719876543", repository.read("C1").getPhoneNumber());
    }

    @Test
    void delete() {
        repository.create(contact);
        assertTrue(repository.delete("C1"));
        assertNull(repository.read("C1"));
    }

    @Test
    void getAll() {
        repository.create(contact);
        assertEquals(1, repository.getAll().size());
    }
}