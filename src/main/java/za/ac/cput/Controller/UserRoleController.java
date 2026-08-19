package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.UserRole;
import za.ac.cput.Service.UserRoleService;
import java.util.List;

@RestController
@RequestMapping("/api/userrole")
public class UserRoleController {
    @Autowired private UserRoleService service;

    @PostMapping("/create") public UserRole create(@RequestBody UserRole userRole) { return service.create(userRole); }
    @GetMapping("/read/{id}") public UserRole read(@PathVariable String id) { return service.read(id); }
    @PutMapping("/update") public UserRole update(@RequestBody UserRole userRole) { return service.update(userRole); }
    @DeleteMapping("/delete/{id}") public boolean delete(@PathVariable String id) { return service.delete(id); }
    @GetMapping("/getAll") public List<UserRole> getAll() { return service.getAll(); }
}