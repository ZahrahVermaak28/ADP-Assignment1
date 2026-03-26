package za.ac.cput.Repository;

import za.ac.cput.Domain.Order;

import java.util.Set;

public interface IOrderRepository {
    Order create(Order order);
    Order read(String orderId);
    Order update(Order order);
    boolean delete(String orderId);
    Set<Order> getAll();
}