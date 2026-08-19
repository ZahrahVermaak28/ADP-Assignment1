package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Contact;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactServiceTest {

    @Autowired
    private ContactService service;
    private static final Contact contact = new Contact.Builder()
            .setContactId("CS1").setPhoneNumber("0821234567").build();

    @Test
    void a_create() {
        Contact created = service.create(contact);
        assertNotNull(created);
        assertEquals("CS1", created.getContactId());
    }

    @Test
    void b_read() {
        Contact read = service.read("CS1");
        assertNotNull(read);
        assertEquals("0821234567", read.getPhoneNumber());
    }

    @Test
    void c_update() {
        Contact updated = new Contact.Builder()
                .setContactId("CS1").setPhoneNumber("0719876543").build();
        assertNotNull(service.update(updated));
        assertEquals("0719876543", service.read("CS1").getPhoneNumber());
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    void e_delete() {
        assertTrue(service.delete("CS1"));
        assertNull(service.read("CS1"));
    }
}