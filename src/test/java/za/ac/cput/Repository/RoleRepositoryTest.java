package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Role;
import za.ac.cput.repositoryImpl.RoleRepository;
import static org.junit.jupiter.api.Assertions.*;

class RoleRepositoryTest {
    private IRoleRepository repository;
    private Role role;

    @BeforeEach
    void setUp() {
        repository = RoleRepository.getRepository();
        repository.getAll().clear();
        role = new Role.Builder().setRoleId("R1").setRoleName("Admin").setDescription("Administrator").build();
    }

    @Test
    void create() {
        Role created = repository.create(role);
        assertNotNull(created);
    }

    @Test
    void read() {
        repository.create(role);
        assertNotNull(repository.read("R1"));
    }

    @Test
    void update() {
        repository.create(role);
        Role updatedRole = new Role.Builder().setRoleId("R1").setRoleName("SuperAdmin").setDescription("Administrator").build();
        assertNotNull(repository.update(updatedRole));
        assertEquals("SuperAdmin", repository.read("R1").getRoleName());
    }

    @Test
    void delete() {
        repository.create(role);
        assertTrue(repository.delete("R1"));
    }

    @Test
    void getAll() {
        repository.create(role);
        assertEquals(1, repository.getAll().size());
    }
}