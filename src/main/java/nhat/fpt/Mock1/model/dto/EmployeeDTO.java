package nhat.fpt.Mock1.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class EmployeeDTO {
    private String employeeName;
    private String employeePhone;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date employeeBirthdate;
    private String sex;
    private String employeeAddress;
    @JsonFormat(pattern= "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    private String employeeEmail;

    private String account;
    private String password;
    private String department;
}
