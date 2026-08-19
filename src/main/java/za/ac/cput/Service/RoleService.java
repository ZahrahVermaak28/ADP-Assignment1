package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Role;
import za.ac.cput.Repository.IRoleRepository;
import za.ac.cput.repositoryImpl.RoleRepository;
import java.util.List;

@Service
public class RoleService {
    private final IRoleRepository repository = RoleRepository.getRepository();

    public Role create(Role role) { return repository.create(role); }
    public Role read(String id) { return repository.read(id); }
    public Role update(Role role) { return repository.update(role); }
    public boolean delete(String id) { return repository.delete(id); }
    public List<Role> getAll() { return repository.getAll(); }
}