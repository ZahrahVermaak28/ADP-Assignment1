package za.ac.cput.Service;
/**
 * @author Olona Williams 221630635
 */

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Payment;
import za.ac.cput.Repository.IPaymentRepository;
import za.ac.cput.repositoryImpl.PaymentRepository;

@Service
public class PaymentService {
    private final IPaymentRepository repository = PaymentRepository.getRepository();

    public Payment create(Payment payment) { return repository.create(payment); }
    public Payment read(String paymentId) { return repository.read(paymentId); }
    public Payment update(Payment payment) { return repository.update(payment); }
    public boolean delete(String paymentId) { return repository.delete(paymentId); }
    public java.util.List<Payment> getAllPayments() { return repository.getAllPayment(); }
}