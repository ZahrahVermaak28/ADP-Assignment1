package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
        import za.ac.cput.Domain.Order;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "/api/order";
    private static final Order order = new Order.Builder()
            .setOrderId("O1").setUserId("U1").setProductList(Arrays.asList("Milk")).setTotalAmount(20.0).build();

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order, Order.class);
        assertNotNull(postResponse.getBody());
        assertEquals("O1", postResponse.getBody().getOrderId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/O1";
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        assertEquals(20.0, response.getBody().getTotalAmount());
    }

    @Test
    void c_update() {
        String url = baseURL + "/update";
        Order updated = new Order.Builder()
                .setOrderId("O1").setUserId("U1").setProductList(Arrays.asList("Milk", "Bread")).setTotalAmount(45.0).build();
        HttpEntity<Order> requestUpdate = new HttpEntity<>(updated, new HttpHeaders());
        ResponseEntity<Order> response = restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, Order.class);
        assertNotNull(response.getBody());
        assertEquals(45.0, response.getBody().getTotalAmount());
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/O1";
        restTemplate.delete(url);
        ResponseEntity<Order> response = restTemplate.getForEntity(baseURL + "/read/O1", Order.class);
        assertNull(response.getBody());
    }
}