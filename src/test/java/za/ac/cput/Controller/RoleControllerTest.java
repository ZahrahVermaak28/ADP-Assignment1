package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Domain.Role;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class RoleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "/api/role";
    private static final Role role = new Role.Builder()
            .setRoleId("R1").setRoleName("Admin").setDescription("Desc").build();

    @Test
    void a_create() {
        ResponseEntity<Role> response = restTemplate.postForEntity(baseURL + "/create", role, Role.class);
        assertNotNull(response.getBody());
        assertEquals("R1", response.getBody().getRoleId());
    }

    @Test
    void b_read() {
        ResponseEntity<Role> response = restTemplate.getForEntity(baseURL + "/read/R1", Role.class);
        assertEquals("Admin", response.getBody().getRoleName());
    }

    @Test
    void c_update() {
        Role updated = new Role.Builder().setRoleId("R1").setRoleName("User").setDescription("Desc").build();
        HttpEntity<Role> req = new HttpEntity<>(updated, new HttpHeaders());
        ResponseEntity<Role> response = restTemplate.exchange(baseURL + "/update", HttpMethod.PUT, req, Role.class);
        assertEquals("User", response.getBody().getRoleName());
    }

    @Test
    void d_getAll() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseURL + "/getAll", String.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        restTemplate.delete(baseURL + "/delete/R1");
        assertNull(restTemplate.getForEntity(baseURL + "/read/R1", Role.class).getBody());
    }
}