package za.ac.cput.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Register;
import za.ac.cput.Service.RegisterService;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/create")
    public Register createRegister(@RequestBody Register register) {
        return registerService.create(register);
    }

    @GetMapping("/read/{registerId}")
    public Register readRegister(@PathVariable("registerId") String registerId) {
        return registerService.read(registerId);
    }

    @PutMapping("/update")
    public Register updateRegister(@RequestBody Register register) {
        return registerService.update(register);
    }

    @DeleteMapping("/delete/{registerId}")
    public boolean deleteRegister(@PathVariable("registerId") String registerId) {
        return registerService.delete(registerId);
    }

    @GetMapping("/getall")
    public List<Register> getAllRegisters() {
        return registerService.getAllRegisters();
    }
}
