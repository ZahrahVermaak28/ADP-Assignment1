package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Address;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressServiceTest {

    @Autowired
    private AddressService service;
    private static final Address address = new Address.Builder()
            .setAddressId("AS1").setStreet("10 Long St").setCity("Cape Town").setPostalCode("8000").build();

    @Test
    void a_create() {
        Address created = service.create(address);
        assertNotNull(created);
        assertEquals("AS1", created.getAddressId());
    }

    @Test
    void b_read() {
        Address read = service.read("AS1");
        assertNotNull(read);
        assertEquals("Cape Town", read.getCity());
    }

    @Test
    void c_update() {
        Address updated = new Address.Builder()
                .setAddressId("AS1").setStreet("20 Short St").setCity("Cape Town").setPostalCode("8000").build();
        assertNotNull(service.update(updated));
        assertEquals("20 Short St", service.read("AS1").getStreet());
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    void e_delete() {
        assertTrue(service.delete("AS1"));
        assertNull(service.read("AS1"));
    }
}