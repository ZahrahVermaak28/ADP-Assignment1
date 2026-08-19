package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.User;
import za.ac.cput.Repository.IUserRepository;
import za.ac.cput.repositoryImpl.UserRepository;
import java.util.List;

@Service
public class UserService {
    private final IUserRepository repository = UserRepository.getRepository();

    public User create(User user) { return repository.create(user); }
    public User read(String id) { return repository.read(id); }
    public User update(User user) { return repository.update(user); }
    public boolean delete(String id) { return repository.delete(id); }
    public List<User> getAll() { return repository.getAllUser(); }
}