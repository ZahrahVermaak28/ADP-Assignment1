package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Domain.Product;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "/api/product";
    private static final Product product = new Product.Builder()
            .SetProductId("P1").SetProductName("Laptop").SetDescription("15-inch laptop").SetPrice(999.99).SetIsAuction(false).build();

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, product, Product.class);
        assertNotNull(postResponse.getBody());
        assertEquals("P1", postResponse.getBody().getProductId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/P1";
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        assertEquals(999.99, response.getBody().getPrice());
    }

    @Test
    void c_update() {
        String url = baseURL + "/update";
        Product updated = new Product.Builder()
                .SetProductId("P1").SetProductName("Laptop").SetDescription("15-inch laptop, 16GB RAM").SetPrice(1099.99).SetIsAuction(false).build();
        HttpEntity<Product> requestUpdate = new HttpEntity<>(updated, new HttpHeaders());
        ResponseEntity<Product> response = restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, Product.class);
        assertNotNull(response.getBody());
        assertEquals(1099.99, response.getBody().getPrice());
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/P1";
        restTemplate.delete(url);
        ResponseEntity<Product> response = restTemplate.getForEntity(baseURL + "/read/P1", Product.class);
        assertNull(response.getBody());
    }
}