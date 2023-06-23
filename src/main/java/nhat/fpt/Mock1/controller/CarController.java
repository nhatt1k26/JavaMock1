package nhat.fpt.Mock1.controller;

import nhat.fpt.Mock1.model.dto.CarDTO;
import nhat.fpt.Mock1.model.response.CarResponse;
import nhat.fpt.Mock1.model.response.CarResponse;
import nhat.fpt.Mock1.service.CarService;
import nhat.fpt.Mock1.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    private final ModelMapper modelMapper;

    public CarController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarResponse>> findAllCar(){
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> findById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(carService.findById(id));
    }
    @PostMapping("/addCar")
    public ResponseEntity<String> addCar(
            @RequestBody CarDTO newCar
    )
    {
        carService.addCar(newCar);
        return ResponseEntity.ok("Add new employee successful");
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<String> updateCar(
            @PathVariable String id,
            @RequestBody CarDTO newCar
    )
    {
        carService.updateCar(id,newCar);
        return ResponseEntity.ok("Update new employee successful");
    }
    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<String> deleteCar(
            @PathVariable String id
    )
    {
        carService.deleteCar(id);
        return ResponseEntity.ok("Delete new employee successful");
    }
}
