package nhat.fpt.Mock1.controller;

import nhat.fpt.Mock1.model.dto.EmployeeDTO;
import nhat.fpt.Mock1.model.entity.Employee;
import nhat.fpt.Mock1.model.response.EmployeeResponse;
import nhat.fpt.Mock1.repository.EmployeeRepository;
import nhat.fpt.Mock1.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponse>> findAllEmployee(){
        if (employeeService.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(
            @RequestBody EmployeeDTO newEmployee
            )
    {
        employeeService.addEmployee(newEmployee);
        return ResponseEntity.ok("Add new employee successful");
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeDTO newEmployee
    )
    {
        employeeService.updateEmployee(id,newEmployee);
        return ResponseEntity.ok("Update new employee successful");
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id
    )
    {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Delete new employee successful");
    }
}
