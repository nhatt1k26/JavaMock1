package nhat.fpt.Mock1.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;


import java.time.LocalDate;
@Getter
public class BookingOfficeDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endContractDeadline;
    private String officeName;
    @JsonFormat(pattern=  "^\\+(?:[0-9]?){6,14}[0-9]$")
    private String officePhone;
    private String officePlace;
    private Long officePrice;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startContractDeadline;
    private Long tripId;
}
