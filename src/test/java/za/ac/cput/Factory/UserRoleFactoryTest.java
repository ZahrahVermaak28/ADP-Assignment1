package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.UserRole;
import static org.junit.jupiter.api.Assertions.*;

class UserRoleFactoryTest {
    @Test
    void createUserRole_success() {
        UserRole userRole = UserRoleFactory.createUserRole("U1", "R1", "User is an Admin");
        assertNotNull(userRole);
        assertEquals("U1", userRole.getUserId());
        assertEquals("R1", userRole.getRoleId());
    }

    @Test
    void createUserRole_fail_nullUserId() {
        UserRole userRole = UserRoleFactory.createUserRole(null, "R1", "User is an Admin");
        assertNull(userRole);
    }
}