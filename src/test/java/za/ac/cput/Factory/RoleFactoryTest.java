package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Role;
import static org.junit.jupiter.api.Assertions.*;

class RoleFactoryTest {
    @Test
    void createRole_success() {
        Role role = RoleFactory.createRole("R1", "Admin", "System Administrator");
        assertNotNull(role);
        assertEquals("R1", role.getRoleId());
        assertEquals("Admin", role.getRoleName());
    }

    @Test
    void createRole_fail_nullName() {
        Role role = RoleFactory.createRole("R1", null, "System Administrator");
        assertNull(role);
    }
}