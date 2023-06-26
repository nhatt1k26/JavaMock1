package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.model.dto.EmployeeDTO;
import nhat.fpt.Mock1.model.entity.Employee;
import nhat.fpt.Mock1.model.response.EmployeeResponse;
import nhat.fpt.Mock1.utilities.CustomPage;

import java.util.List;
public interface EmployeeService {
    boolean isEmpty();
    List<EmployeeResponse> findAll();
    EmployeeResponse findById(Long id);
    void addEmployee(EmployeeDTO e);
    void updateEmployee(Long id,EmployeeDTO e);
    void deleteEmployee(Long id);
}
