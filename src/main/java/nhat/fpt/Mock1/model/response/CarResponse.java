package nhat.fpt.Mock1.model.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {
    private String licensePlate;
    private String carColor;
    private String company;
}
