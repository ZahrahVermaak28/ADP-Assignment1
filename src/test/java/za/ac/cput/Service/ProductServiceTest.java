package za.ac.cput.Service;
/**
 * @author Olona Williams 221630635
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Product;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceTest {

    @Autowired
    private ProductService service;
    private static final Product product = new Product.Builder()
            .SetProductId("P1").SetProductName("Laptop").SetDescription("15-inch laptop").SetPrice(999.99).SetIsAuction(false).build();

    @Test
    void a_create() {
        Product created = service.create(product);
        assertNotNull(created);
        assertEquals("P1", created.getProductId());
    }

    @Test
    void b_read() {
        Product read = service.read("P1");
        assertNotNull(read);
        assertEquals(999.99, read.getPrice());
    }

    @Test
    void c_update() {
        Product updated = new Product.Builder()
                .SetProductId("P1").SetProductName("Laptop").SetDescription("15-inch laptop, 16GB RAM").SetPrice(1099.99).SetIsAuction(false).build();
        assertNotNull(service.update(updated));
        assertEquals(1099.99, service.read("P1").getPrice());
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    void e_delete() {
        assertTrue(service.delete("P1"));
        assertNull(service.read("P1"));
    }
}
