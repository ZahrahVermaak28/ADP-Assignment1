package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Contact;
import za.ac.cput.Service.ContactService;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired private ContactService service;

    @PostMapping("/create") public Contact create(@RequestBody Contact contact) { return service.create(contact); }
    @GetMapping("/read/{id}") public Contact read(@PathVariable String id) { return service.read(id); }
    @PutMapping("/update") public Contact update(@RequestBody Contact contact) { return service.update(contact); }
    @DeleteMapping("/delete/{id}") public boolean delete(@PathVariable String id) { return service.delete(id); }
    @GetMapping("/getAll") public List<Contact> getAll() { return service.getAll(); }
}