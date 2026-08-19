package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.UserRole;
import za.ac.cput.Repository.IUserRoleRepository;
import za.ac.cput.repositoryImpl.UserRoleRepository;
import java.util.List;

@Service
public class UserRoleService {
    private final IUserRoleRepository repository = UserRoleRepository.getRepository();

    public UserRole create(UserRole userRole) { return repository.create(userRole); }
    public UserRole read(String id) { return repository.read(id); }
    public UserRole update(UserRole userRole) { return repository.update(userRole); }
    public boolean delete(String id) { return repository.delete(id); }
    public List<UserRole> getAll() { return repository.getAll(); }
}