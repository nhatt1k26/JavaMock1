package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.exception.EntityNotFoundException;
import nhat.fpt.Mock1.model.dto.EmployeeDTO;
import nhat.fpt.Mock1.model.entity.Employee;
import nhat.fpt.Mock1.model.response.EmployeeResponse;
import nhat.fpt.Mock1.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public boolean isEmpty(){
        return !employeeRepository.findAll().isEmpty();
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeResponse> findAll(){
        return employeeRepository.findAll().stream().map(s->modelMapper.map(s, EmployeeResponse.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse findById(Long id){
        Employee result = employeeRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("Employee with id= "+ id + " not found");});
        return modelMapper.map(result,EmployeeResponse.class);
    }

    @Override
    public void addEmployee(EmployeeDTO e){
        employeeRepository.save(modelMapper.map(e,Employee.class));
    }

    @Override
    public void updateEmployee(Long id, EmployeeDTO e){
        if (!employeeRepository.existsById(id))
            throw new EntityNotFoundException("Employee with id="+id+" not found.");
        Employee employeeToUpdate = modelMapper.map(e, Employee.class);
        employeeToUpdate.setId(id);
        employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(Long id){
        if (!employeeRepository.existsById(id))
            throw new EntityNotFoundException("Employee with id="+id+" not found.");
        employeeRepository.deleteById(id);
    }


}
