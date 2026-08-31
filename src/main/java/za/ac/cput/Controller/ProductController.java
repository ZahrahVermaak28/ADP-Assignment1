package za.ac.cput.Controller;
/**
 * @author Olona Williams 221630635
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Product;
import za.ac.cput.Service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired private ProductService service;

    @PostMapping("/create") public Product create(@RequestBody Product product) { return service.create(product); }
    @GetMapping("/read/{productId}") public Product read(@PathVariable String productId) { return service.read(productId); }
    @PutMapping("/update") public Product update(@RequestBody Product product) { return service.update(product); }
    @DeleteMapping("/delete/{productId}") public boolean delete(@PathVariable String productId) { return service.delete(productId); }
    @GetMapping("/all") public List<Product> getAll() { return service.getAll(); }
}