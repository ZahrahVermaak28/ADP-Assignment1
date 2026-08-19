package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.User;
import za.ac.cput.Service.UserService;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired private UserService service;

    @PostMapping("/create") public User create(@RequestBody User user) { return service.create(user); }
    @GetMapping("/read/{id}") public User read(@PathVariable String id) { return service.read(id); }
    @PutMapping("/update") public User update(@RequestBody User user) { return service.update(user); }
    @DeleteMapping("/delete/{id}") public boolean delete(@PathVariable String id) { return service.delete(id); }
    @GetMapping("/getAll") public List<User> getAll() { return service.getAll(); }
}