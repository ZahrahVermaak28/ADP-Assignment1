package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Register;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegisterServiceImplTest {

    private RegisterServiceImpl registerService;

    @BeforeEach
    void setUp() {
        registerService = new RegisterServiceImpl();
    }

    @Test
    void create() {
        Register register = new Register.Builder().setRegisterId("R001").setEmail("test@gmail.com").build();

        Register result = registerService.create(register);

        assertNotNull(result);
        assertEquals("R001", result.getRegisterId());
        assertEquals("test@gmail.com", result.getEmail());
    }

    @Test
    void read() {
        Register register = new Register.Builder().setRegisterId("R002").setEmail("read@gmail.com").build();

        registerService.create(register);

        Register result = registerService.read("R002");

        assertNotNull(result);
        assertEquals("R002", result.getRegisterId());
        assertEquals("read@gmail.com", result.getEmail());
    }

    @Test
    void update() {
        Register register = new Register.Builder().setRegisterId("R003").setEmail("old@gmail.com").build();

        registerService.create(register);

        Register updatedRegister = new Register.Builder().setRegisterId("R003").setEmail("new@gmail.com").build();

        Register result = registerService.update(updatedRegister);

        assertNotNull(result);
        assertEquals("R003", result.getRegisterId());
        assertEquals("new@gmail.com", result.getEmail());
    }

    @Test
    void delete() {
        Register register = new Register.Builder().setRegisterId("R004").setEmail("delete@gmail.com").build();

        registerService.create(register);

        boolean result = registerService.delete("R004");

        assertTrue(result);
        assertNull(registerService.read("R004"));
    }

    @Test
    void getAllRegisters() {
        Register register1 = new Register.Builder().setRegisterId("R005").setEmail("one@gmail.com").build();

        Register register2 = new Register.Builder().setRegisterId("R006").setEmail("two@gmail.com").build();

        registerService.create(register1);
        registerService.create(register2);

        List<Register> result = registerService.getAllRegisters();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}