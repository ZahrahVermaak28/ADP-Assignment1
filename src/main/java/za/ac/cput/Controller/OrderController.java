package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Order;
import za.ac.cput.Service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired private OrderService service;

    @PostMapping("/create") public Order create(@RequestBody Order order) { return service.create(order); }
    @GetMapping("/read/{id}") public Order read(@PathVariable String id) { return service.read(id); }
    @PutMapping("/update") public Order update(@RequestBody Order order) { return service.update(order); }
    @DeleteMapping("/delete/{id}") public boolean delete(@PathVariable String id) { return service.delete(id); }
    @GetMapping("/getAll") public List<Order> getAll() { return service.getAll(); }
}