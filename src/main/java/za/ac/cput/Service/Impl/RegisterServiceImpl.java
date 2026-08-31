package za.ac.cput.Service.Impl;


import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Register;
import za.ac.cput.Service.RegisterService;

import java.util.*;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final List<Register> registers = new ArrayList<>();

    @Override
    public Register create(Register register) {
        registers.add(register);
        return register;
    }

    @Override
    public Register read(String registerId) {
        for (Register register : registers) {
            if (register.getRegisterId().equals(registerId)) {
                return register;
            }
        }
        return null;
    }

    @Override
    public Register update(Register register) {
        Register existingRegister = read(register.getRegisterId());
        if (existingRegister != null) {
            registers.remove(existingRegister);
            registers.add(register);
            return register;
        }
        return null;
    }

    @Override
    public boolean delete(String registerId) {
        Register register = read(registerId);
        if (register != null) {
            registers.remove(register);
            return true;
        }
        return false;
    }

    @Override
    public List<Register> getAllRegisters() {
        return registers;
    }
}
