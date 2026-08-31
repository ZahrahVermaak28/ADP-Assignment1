package za.ac.cput.Service;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Payment;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {

    @Autowired
    private PaymentService service;
    private static final Payment payment = new Payment.Builder()
            .setPaymentId("PAY1").setAmount(150.00).setPaymentMethod("CREDIT_CARD").build();

    @Test
    void a_create() {
        Payment created = service.create(payment);
        assertNotNull(created);
        assertEquals("PAY1", created.getPaymentId());
    }

    @Test
    void b_read() {
        Payment read = service.read("PAY1");
        assertNotNull(read);
        assertEquals(150.00, read.getAmount());
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder()
                .setPaymentId("PAY1").setAmount(200.00).setPaymentMethod("EFT").build();
        assertNotNull(service.update(updated));
        assertEquals(200.00, service.read("PAY1").getAmount());
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAllPayments().isEmpty());
    }

    @Test
    void e_delete() {
        assertTrue(service.delete("PAY1"));
        assertNull(service.read("PAY1"));
    }
}