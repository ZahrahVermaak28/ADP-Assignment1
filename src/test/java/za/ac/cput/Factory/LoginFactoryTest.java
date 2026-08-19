package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Login;
import static org.junit.jupiter.api.Assertions.*;

class LoginFactoryTest {
    @Test
    void createLogin_success() {
        Login login = LoginFactory.createLogin("Elona", "password123");
        assertNotNull(login);
        assertEquals("Elona", login.getUsername());
        assertEquals("password123", login.getPassword());
    }

    @Test
    void createLogin_fail_nullUsername() {
        Login login = LoginFactory.createLogin(null, "password123");
        assertNull(login);
    }
}