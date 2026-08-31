package za.ac.cput.Controller;
/**
 * @author Olona Williams 221630635
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Payment;
import za.ac.cput.Service.PaymentService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired private PaymentService service;

    @PostMapping("/create")
    public Payment create(@RequestBody Map<String, Object> body) {
        Payment payment = new Payment.Builder()
                .setPaymentId((String) body.get("paymentId"))
                .setAmount(((Number) body.get("amount")).doubleValue())
                .setPaymentMethod((String) body.get("paymentMethod"))
                .build();
        return service.create(payment);
    }

    @GetMapping("/read/{paymentId}")
    public Payment read(@PathVariable String paymentId) {
        return service.read(paymentId);
    }

    @PutMapping("/update")
    public Payment update(@RequestBody Map<String, Object> body) {
        Payment payment = new Payment.Builder()
                .setPaymentId((String) body.get("paymentId"))
                .setAmount(((Number) body.get("amount")).doubleValue())
                .setPaymentMethod((String) body.get("paymentMethod"))
                .build();
        return service.update(payment);
    }

    @DeleteMapping("/delete/{paymentId}")
    public boolean delete(@PathVariable String paymentId) {
        return service.delete(paymentId);
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }
}