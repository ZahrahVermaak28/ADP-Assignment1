package za.ac.cput.Service;

import za.ac.cput.Domain.Register;

import java.util.List;

public interface RegisterService extends IService<Register, String>{

    List<Register> getAllRegisters();
}
