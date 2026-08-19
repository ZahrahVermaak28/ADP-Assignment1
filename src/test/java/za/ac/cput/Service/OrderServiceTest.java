package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Order;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {

    @Autowired
    private OrderService service;
    private static final Order order = new Order.Builder()
            .setOrderId("O1").setUserId("U1").setProductList(Arrays.asList("Apple", "Bread")).setTotalAmount(50.00).build();

    @Test
    void a_create() {
        Order created = service.create(order);
        assertNotNull(created);
        assertEquals("O1", created.getOrderId());
    }

    @Test
    void b_read() {
        Order read = service.read("O1");
        assertNotNull(read);
        assertEquals(50.00, read.getTotalAmount());
    }

    @Test
    void c_update() {
        Order updated = new Order.Builder()
                .setOrderId("O1").setUserId("U1").setProductList(Arrays.asList("Apple", "Bread", "Milk")).setTotalAmount(75.00).build();
        assertNotNull(service.update(updated));
        assertEquals(75.00, service.read("O1").getTotalAmount());
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    void e_delete() {
        assertTrue(service.delete("O1"));
        assertNull(service.read("O1"));
    }
}