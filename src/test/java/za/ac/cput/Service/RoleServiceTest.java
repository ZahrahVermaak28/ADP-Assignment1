package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Role;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class RoleServiceTest {

    @Autowired
    private RoleService service;
    private static final Role role = new Role.Builder()
            .setRoleId("RS1").setRoleName("Admin").setDescription("System Admin").build();

    @Test
    void a_create() {
        Role created = service.create(role);
        assertNotNull(created);
        assertEquals("RS1", created.getRoleId());
    }

    @Test
    void b_read() {
        Role read = service.read("RS1");
        assertNotNull(read);
        assertEquals("Admin", read.getRoleName());
    }

    @Test
    void c_update() {
        Role updated = new Role.Builder()
                .setRoleId("RS1").setRoleName("SuperAdmin").setDescription("System Admin").build();
        assertNotNull(service.update(updated));
        assertEquals("SuperAdmin", service.read("RS1").getRoleName());
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    void e_delete() {
        assertTrue(service.delete("RS1"));
        assertNull(service.read("RS1"));
    }
}