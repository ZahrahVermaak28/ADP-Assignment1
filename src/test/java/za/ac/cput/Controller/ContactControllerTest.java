package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Domain.Contact;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "/api/contact";
    private static final Contact contact = new Contact.Builder()
            .setContactId("C1").setPhoneNumber("0123").build();

    @Test
    void a_create() {
        ResponseEntity<Contact> response = restTemplate.postForEntity(baseURL + "/create", contact, Contact.class);
        assertNotNull(response.getBody());
        assertEquals("C1", response.getBody().getContactId());
    }

    @Test
    void b_read() {
        ResponseEntity<Contact> response = restTemplate.getForEntity(baseURL + "/read/C1", Contact.class);
        assertEquals("0123", response.getBody().getPhoneNumber());
    }

    @Test
    void c_update() {
        Contact updated = new Contact.Builder().setContactId("C1").setPhoneNumber("0987").build();
        HttpEntity<Contact> req = new HttpEntity<>(updated, new HttpHeaders());
        ResponseEntity<Contact> response = restTemplate.exchange(baseURL + "/update", HttpMethod.PUT, req, Contact.class);
        assertEquals("0987", response.getBody().getPhoneNumber());
    }

    @Test
    void d_getAll() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseURL + "/getAll", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        restTemplate.delete(baseURL + "/delete/C1");
        assertNull(restTemplate.getForEntity(baseURL + "/read/C1", Contact.class).getBody());
    }
}