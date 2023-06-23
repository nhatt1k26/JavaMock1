package nhat.fpt.Mock1.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length =50)
    private String account;
    @Column(length = 10)
    private String department;
    @Column(length =50)
    private String employeeAddress;
    private Date employeeBirthdate;
    @Column(length = 50)
    private String employeeEmail;
    @Column(length = 50)
    private String employeeName;
    @Column(length = 10)
    private String employeePhone;
    @Column(length = 20)
    private String password;
    @Column(length = 1)
    private String sex;
}
