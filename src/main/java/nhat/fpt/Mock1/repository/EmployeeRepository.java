package nhat.fpt.Mock1.repository;

import nhat.fpt.Mock1.model.entity.Employee;
import nhat.fpt.Mock1.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
