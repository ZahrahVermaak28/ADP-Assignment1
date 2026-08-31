package za.ac.cput.Service;
/**
 * @author Olona Williams 221630635
 */
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Product;
import za.ac.cput.Repository.IProductRepository;
import za.ac.cput.repositoryImpl.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final IProductRepository repository = ProductRepository.getRepository();

    public Product create(Product product) { return repository.create(product); }
    public Product read(String productId) { return repository.read(productId); }
    public Product update(Product product) { return repository.update(product); }
    public boolean delete(String productId) { return repository.delete(productId); }
    public List<Product> getAll() { return repository.getAll(); }
}