package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Role;
import za.ac.cput.Service.RoleService;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired private RoleService service;

    @PostMapping("/create") public Role create(@RequestBody Role role) { return service.create(role); }
    @GetMapping("/read/{id}") public Role read(@PathVariable String id) { return service.read(id); }
    @PutMapping("/update") public Role update(@RequestBody Role role) { return service.update(role); }
    @DeleteMapping("/delete/{id}") public boolean delete(@PathVariable String id) { return service.delete(id); }
    @GetMapping("/getAll") public List<Role> getAll() { return service.getAll(); }
}