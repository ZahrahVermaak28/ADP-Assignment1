package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Login;
import za.ac.cput.repositoryImpl.LoginRepository;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LoginRepositoryTest {
    private static final ILoginRepository repository = LoginRepository.getRepository();
    private static final Login login = new Login.Builder().setUsername("Elona").setPassword("pass123").build();

    @Test
    void a_create() {
        Login created = repository.create(login);
        assertNotNull(created);
        assertEquals("Elona", created.getUsername());
    }

    @Test
    void b_read() {
        Login read = repository.read("Elona");
        assertNotNull(read);
    }

    @Test
    void c_update() {
        Login updatedLogin = new Login.Builder().setUsername("Elona").setPassword("newPass456").build();
        assertNotNull(repository.update(updatedLogin));
        assertEquals("newPass456", repository.read("Elona").getPassword());
    }

    @Test
    void d_delete() {
        assertTrue(repository.delete("Elona"));
        assertNull(repository.read("Elona"));
    }
}