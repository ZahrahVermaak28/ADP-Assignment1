package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Domain.Login;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class LoginControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "/api/login";
    private static final Login login = new Login.Builder()
            .setUsername("Admin").setPassword("1234").build();

    @Test
    void a_create() {
        ResponseEntity<Login> response = restTemplate.postForEntity(baseURL + "/create", login, Login.class);
        assertNotNull(response.getBody());
        assertEquals("Admin", response.getBody().getUsername());
    }

    @Test
    void b_read() {
        ResponseEntity<Login> response = restTemplate.getForEntity(baseURL + "/read/Admin", Login.class);
        assertEquals("1234", response.getBody().getPassword());
    }

    @Test
    void c_update() {
        Login updated = new Login.Builder().setUsername("Admin").setPassword("0000").build();
        HttpEntity<Login> req = new HttpEntity<>(updated, new HttpHeaders());
        ResponseEntity<Login> response = restTemplate.exchange(baseURL + "/update", HttpMethod.PUT, req, Login.class);
        assertEquals("0000", response.getBody().getPassword());
    }

    @Test
    void d_delete() {
        restTemplate.delete(baseURL + "/delete/Admin");
        assertNull(restTemplate.getForEntity(baseURL + "/read/Admin", Login.class).getBody());
    }
}