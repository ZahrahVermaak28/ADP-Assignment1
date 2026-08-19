package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Address;
import za.ac.cput.Repository.IAddressRepository;
import za.ac.cput.repositoryImpl.AddressRepository;
import java.util.List;

@Service
public class AddressService {
    private final IAddressRepository repository = AddressRepository.getRepository();

    public Address create(Address address) { return repository.create(address); }
    public Address read(String id) { return repository.read(id); }
    public Address update(Address address) { return repository.update(address); }
    public boolean delete(String id) { return repository.delete(id); }
    public List<Address> getAll() { return repository.getAllAddress(); }
}