package nhat.fpt.Mock1.model.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class EmployeeResponse {
    private Long id;
    private String employeeName;
    private String account;
    private String department;
    private String employeeAddress;
    private Date employeeBirthdate;
    private String employeePhone;

}
