package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Domain.Address;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "/api/address";
    private static final Address address = new Address.Builder()
            .setAddressId("A1").setStreet("Main").setCity("CT").setPostalCode("8000").build();

    @Test
    void a_create() {
        ResponseEntity<Address> response = restTemplate.postForEntity(baseURL + "/create", address, Address.class);
        assertNotNull(response.getBody());
        assertEquals("A1", response.getBody().getAddressId());
    }

    @Test
    void b_read() {
        ResponseEntity<Address> response = restTemplate.getForEntity(baseURL + "/read/A1", Address.class);
        assertEquals("CT", response.getBody().getCity());
    }

    @Test
    void c_update() {
        Address updated = new Address.Builder().setAddressId("A1").setStreet("Loop").setCity("CT").setPostalCode("8000").build();
        HttpEntity<Address> req = new HttpEntity<>(updated, new HttpHeaders());
        ResponseEntity<Address> response = restTemplate.exchange(baseURL + "/update", HttpMethod.PUT, req, Address.class);
        assertEquals("Loop", response.getBody().getStreet());
    }

    @Test
    void d_getAll() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseURL + "/getAll", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        restTemplate.delete(baseURL + "/delete/A1");
        assertNull(restTemplate.getForEntity(baseURL + "/read/A1", Address.class).getBody());
    }
}