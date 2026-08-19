package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Contact;
import za.ac.cput.Repository.IContactRepository;
import za.ac.cput.repositoryImpl.ContactRepository;
import java.util.List;

@Service
public class ContactService {
    private final IContactRepository repository = ContactRepository.getRepository();

    public Contact create(Contact contact) { return repository.create(contact); }
    public Contact read(String id) { return repository.read(id); }
    public Contact update(Contact contact) { return repository.update(contact); }
    public boolean delete(String id) { return repository.delete(id); }
    public List<Contact> getAll() { return repository.getAll(); }
}