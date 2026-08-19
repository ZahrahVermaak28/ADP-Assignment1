package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.UserRole;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRoleServiceTest {

    @Autowired
    private UserRoleService service;
    private static final UserRole userRole = new UserRole.Builder()
            .setUserId("URS1").setRoleId("R1").setUserRoleDescription("Admin Rights").build();

    @Test
    void a_create() {
        UserRole created = service.create(userRole);
        assertNotNull(created);
        assertEquals("URS1", created.getUserId());
    }

    @Test
    void b_read() {
        UserRole read = service.read("URS1");
        assertNotNull(read);
        assertEquals("R1", read.getRoleId());
    }

    @Test
    void c_update() {
        UserRole updated = new UserRole.Builder()
                .setUserId("URS1").setRoleId("R2").setUserRoleDescription("Standard Rights").build();
        assertNotNull(service.update(updated));
        assertEquals("R2", service.read("URS1").getRoleId());
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    void e_delete() {
        assertTrue(service.delete("URS1"));
        assertNull(service.read("URS1"));
    }
}