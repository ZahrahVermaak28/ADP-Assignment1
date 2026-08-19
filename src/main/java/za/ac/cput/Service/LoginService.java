package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Login;
import za.ac.cput.Repository.ILoginRepository;
import za.ac.cput.repositoryImpl.LoginRepository;

@Service
public class LoginService {
    private final ILoginRepository repository = LoginRepository.getRepository();

    public Login create(Login login) { return repository.create(login); }
    public Login read(String username) { return repository.read(username); }
    public Login update(Login login) { return repository.update(login); }
    public boolean delete(String username) { return repository.delete(username); }
}