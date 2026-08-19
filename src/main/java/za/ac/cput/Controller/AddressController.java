package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Address;
import za.ac.cput.Service.AddressService;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired private AddressService service;

    @PostMapping("/create") public Address create(@RequestBody Address address) { return service.create(address); }
    @GetMapping("/read/{id}") public Address read(@PathVariable String id) { return service.read(id); }
    @PutMapping("/update") public Address update(@RequestBody Address address) { return service.update(address); }
    @DeleteMapping("/delete/{id}") public boolean delete(@PathVariable String id) { return service.delete(id); }
    @GetMapping("/getAll") public List<Address> getAll() { return service.getAll(); }
}