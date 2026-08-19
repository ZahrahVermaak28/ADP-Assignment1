package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Order;
import za.ac.cput.Repository.IOrderRepository;
import za.ac.cput.repositoryImpl.OrderRepository;
import java.util.List;

@Service
public class OrderService {
    private final IOrderRepository repository = OrderRepository.getRepository();

    public Order create(Order order) { return repository.create(order); }
    public Order read(String id) { return repository.read(id); }
    public Order update(Order order) { return repository.update(order); }
    public boolean delete(String id) { return repository.delete(id); }
    public List<Order> getAll() { return repository.getAll(); }
}