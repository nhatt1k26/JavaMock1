package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.exception.EntityNotFoundException;
import nhat.fpt.Mock1.model.dto.CarDTO;
import nhat.fpt.Mock1.model.entity.Car;
import nhat.fpt.Mock1.model.response.CarResponse;
import nhat.fpt.Mock1.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CarResponse> findAll(){
        return carRepository.findAll().stream().map(s->modelMapper.map(s, CarResponse.class)).collect(Collectors.toList());
    }

    @Override
    public CarResponse findById(String id){
        Car result = carRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("Car with id= "+ id + " not found");});
        return modelMapper.map(result,CarResponse.class);
    }

    @Override
    public void addCar(CarDTO e){
        carRepository.save(modelMapper.map(e,Car.class));
    }

    @Override
    public void updateCar(String id, CarDTO e){
        if (!carRepository.existsById(id))
            throw new EntityNotFoundException("Car with license plate="+id+" not found.");
        Car carToUpdate = modelMapper.map(e, Car.class);
        carToUpdate.setLicensePlate(id);
        carRepository.save(carToUpdate);
    }

    @Override
    public void deleteCar(String id){
        if (!carRepository.existsById(id))
            throw new EntityNotFoundException("Car with id="+id+" not found.");
        carRepository.deleteById(id);
    }
}
