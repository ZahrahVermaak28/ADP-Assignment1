package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Login;
import za.ac.cput.Service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired private LoginService service;

    @PostMapping("/create") public Login create(@RequestBody Login login) { return service.create(login); }
    @GetMapping("/read/{username}") public Login read(@PathVariable String username) { return service.read(username); }
    @PutMapping("/update") public Login update(@RequestBody Login login) { return service.update(login); }
    @DeleteMapping("/delete/{username}") public boolean delete(@PathVariable String username) { return service.delete(username); }
}