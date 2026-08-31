package za.ac.cput.Controller;
/**
 * @author Olona Williams 221630635
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Domain.Payment;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "/api/payment";
    private static final Payment payment = new Payment.Builder()
            .setPaymentId("PAY1").setAmount(150.00).setPaymentMethod("CREDIT_CARD").build();

    @Test
    void a_create() {
        ResponseEntity<Payment> response = restTemplate.postForEntity(baseURL + "/create", payment, Payment.class);
        assertNotNull(response.getBody());
        assertEquals("PAY1", response.getBody().getPaymentId());
    }

    @Test
    void b_read() {
        ResponseEntity<Payment> response = restTemplate.getForEntity(baseURL + "/read/PAY1", Payment.class);
        assertNotNull(response.getBody());
        assertEquals(150.00, response.getBody().getAmount());
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder().setPaymentId("PAY1").setAmount(200.00).setPaymentMethod("EFT").build();
        HttpEntity<Payment> req = new HttpEntity<>(updated, new HttpHeaders());
        ResponseEntity<Payment> response = restTemplate.exchange(baseURL + "/update", HttpMethod.PUT, req, Payment.class);
        assertNotNull(response.getBody());
        assertEquals(200.00, response.getBody().getAmount());
    }

    @Test
    void d_getAll() {
        ResponseEntity<Payment[]> response = restTemplate.getForEntity(baseURL + "/all", Payment[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
    }

    @Test
    void e_delete() {
        restTemplate.delete(baseURL + "/delete/PAY1");
        ResponseEntity<Payment> response = restTemplate.getForEntity(baseURL + "/read/PAY1", Payment.class);
        assertNull(response.getBody());
    }
}