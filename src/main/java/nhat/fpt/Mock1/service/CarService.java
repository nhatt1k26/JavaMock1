package nhat.fpt.Mock1.service;

import lombok.Getter;
import lombok.Setter;
import nhat.fpt.Mock1.model.dto.CarDTO;
import nhat.fpt.Mock1.model.entity.Car;
import nhat.fpt.Mock1.model.response.CarResponse;
import nhat.fpt.Mock1.utilities.CustomPage;

import java.util.List;

public interface CarService {
    boolean isEmpty();
    List<CarResponse> findAll();
    CarResponse findById(String id);
    void addCar(CarDTO e);
    void updateCar(String id,CarDTO e);
    void deleteCar(String id);
}
