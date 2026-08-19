package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.UserRole;
import za.ac.cput.repositoryImpl.UserRoleRepository;
import static org.junit.jupiter.api.Assertions.*;

class UserRoleRepositoryTest {
    private IUserRoleRepository repository;
    private UserRole userRole;

    @BeforeEach
    void setUp() {
        repository = UserRoleRepository.getRepository();
        repository.getAll().clear();
        userRole = new UserRole.Builder().setUserId("U1").setRoleId("R1").setUserRoleDescription("Admin User").build();
    }

    @Test
    void create() {
        assertNotNull(repository.create(userRole));
    }

    @Test
    void read() {
        repository.create(userRole);
        assertNotNull(repository.read("U1"));
    }

    @Test
    void update() {
        repository.create(userRole);
        UserRole updated = new UserRole.Builder().setUserId("U1").setRoleId("R2").setUserRoleDescription("Basic User").build();
        assertNotNull(repository.update(updated));
        assertEquals("R2", repository.read("U1").getRoleId());
    }

    @Test
    void delete() {
        repository.create(userRole);
        assertTrue(repository.delete("U1"));
    }

    @Test
    void getAll() {
        repository.create(userRole);
        assertEquals(1, repository.getAll().size());
    }
}