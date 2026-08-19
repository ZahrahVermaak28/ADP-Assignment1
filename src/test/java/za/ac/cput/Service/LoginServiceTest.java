package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Login;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class LoginServiceTest {

    @Autowired
    private LoginService service;
    private static final Login login = new Login.Builder()
            .setUsername("Elona").setPassword("pass123").build();

    @Test
    void a_create() {
        Login created = service.create(login);
        assertNotNull(created);
        assertEquals("Elona", created.getUsername());
    }

    @Test
    void b_read() {
        Login read = service.read("Elona");
        assertNotNull(read);
        assertEquals("pass123", read.getPassword());
    }

    @Test
    void c_update() {
        Login updated = new Login.Builder()
                .setUsername("Elona").setPassword("newPass456").build();
        assertNotNull(service.update(updated));
        assertEquals("newPass456", service.read("Elona").getPassword());
    }

    @Test
    void d_delete() {
        assertTrue(service.delete("Elona"));
        assertNull(service.read("Elona"));
    }
}