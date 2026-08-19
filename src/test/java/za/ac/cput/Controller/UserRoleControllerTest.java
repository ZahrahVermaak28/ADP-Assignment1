package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Domain.UserRole;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRoleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "/api/userrole";
    private static final UserRole userRole = new UserRole.Builder()
            .setUserId("U1").setRoleId("R1").setUserRoleDescription("Desc").build();

    @Test
    void a_create() {
        ResponseEntity<UserRole> response = restTemplate.postForEntity(baseURL + "/create", userRole, UserRole.class);
        assertNotNull(response.getBody());
        assertEquals("U1", response.getBody().getUserId());
    }

    @Test
    void b_read() {
        ResponseEntity<UserRole> response = restTemplate.getForEntity(baseURL + "/read/U1", UserRole.class);
        assertEquals("R1", response.getBody().getRoleId());
    }

    @Test
    void c_update() {
        UserRole updated = new UserRole.Builder().setUserId("U1").setRoleId("R2").setUserRoleDescription("Desc").build();
        HttpEntity<UserRole> req = new HttpEntity<>(updated, new HttpHeaders());
        ResponseEntity<UserRole> response = restTemplate.exchange(baseURL + "/update", HttpMethod.PUT, req, UserRole.class);
        assertEquals("R2", response.getBody().getRoleId());
    }

    @Test
    void d_getAll() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseURL + "/getAll", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        restTemplate.delete(baseURL + "/delete/U1");
        assertNull(restTemplate.getForEntity(baseURL + "/read/U1", UserRole.class).getBody());
    }
}