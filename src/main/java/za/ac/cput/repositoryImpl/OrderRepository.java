package za.ac.cput.repositoryImpl;

import za.ac.cput.Domain.Order;
import za.ac.cput.Repository.IOrderRepository;

import java.util.HashSet;
import java.util.Set;

public class OrderRepository implements IOrderRepository {
    private static OrderRepository repository = null;
    private Set<Order> orderDB;

    private OrderRepository() {
        orderDB = new HashSet<>();
    }

    // Singleton Pattern
    public static OrderRepository getRepository() {
        if (repository == null) {
            repository = new OrderRepository();
        }
        return repository;
    }

    @Override
    public Order create(Order order) {
        boolean success = orderDB.add(order);
        if (!success) return null;
        return order;
    }

    @Override
    public Order read(String orderId) {
        for (Order o : orderDB) {
            if (o.getOrderId().equals(orderId)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        Order oldOrder = read(order.getOrderId());
        if (oldOrder != null) {
            orderDB.remove(oldOrder);
            orderDB.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(String orderId) {
        Order orderToDelete = read(orderId);
        if (orderToDelete == null) return false;
        orderDB.remove(orderToDelete);
        return true;
    }

    @Override
    public Set<Order> getAll() {
        return orderDB;
    }
}