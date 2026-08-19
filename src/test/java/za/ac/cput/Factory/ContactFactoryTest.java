package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Contact;
import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {
    @Test
    void createContact_success() {
        Contact contact = ContactFactory.createContact("C001", "0821234567");
        assertNotNull(contact);
        assertEquals("C001", contact.getContactId());
        assertEquals("0821234567", contact.getPhoneNumber());
    }

    @Test
    void createContact_fail_nullId() {
        Contact contact = ContactFactory.createContact(null, "0821234567");
        assertNull(contact);
    }
}