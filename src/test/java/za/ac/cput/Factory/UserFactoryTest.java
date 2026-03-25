package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {
    @Test
    void createUser_success() {
        // Create a valid user
        User user = UserFactory.createUser(
                "Zahrah",
                "Vermaak",
                "zahrah@email.com",
                "12345"
        );
        assertNotNull(user, "User should not be null");
        assertNotNull(user.getUserId(), "User ID should be generated");
        assertEquals("Zahrah", user.getName());
        assertEquals("Vermaak", user.getSurname());
        assertEquals("zahrah@email.com", user.getEmail());
        assertEquals("12345", user.getPassword());
    }

    @Test
    void createUser_nullName() {
        // Try to create user with null name
        User user = UserFactory.createUser(
                null,
                "Vermaak",
                "zahrah@email.com",
                "12345"
        );

        assertNull(user, "name should not be empty");
    }

    @Test
    void createUser_nullPassword() {
        // Try to create user with null password
        User user = UserFactory.createUser(
                "Zahrah",
                "Vermaak",
                "zahrah@email.com",
                null
        );

        assertNull(user, "password should not be empty");
    }









}