package nhat.fpt.Mock1.model.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CarDTO {
    private String licensePlate;
    private String carColor;
    private String company;
}
