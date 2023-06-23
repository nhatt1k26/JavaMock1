package nhat.fpt.Mock1.controller;

import nhat.fpt.Mock1.model.dto.ParkingLotDTO;
import nhat.fpt.Mock1.model.response.ParkingLotResponse;
import nhat.fpt.Mock1.service.ParkingLotService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;
    private final ModelMapper modelMapper;

    public ParkingLotController(ParkingLotService parkingLotService, ModelMapper modelMapper) {
        this.parkingLotService = parkingLotService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingLotResponse>> findAllParking(){
        return ResponseEntity.ok(parkingLotService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingLotResponse> findById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(parkingLotService.findById(id));
    }

    @PostMapping("/addParking")
    public ResponseEntity<String> addParking(
            @RequestBody ParkingLotDTO newParking
    )
    {
        parkingLotService.addParkingLot(newParking);
        return ResponseEntity.ok("Add new employee successful");
    }

    @PutMapping("/updateParking/{id}")
    public ResponseEntity<String> updateParking(
            @PathVariable Long id,
            @RequestBody ParkingLotDTO newParking
    )
    {
        parkingLotService.updateParkingLot(id,newParking);
        return ResponseEntity.ok("Update new employee successful");
    }
    @DeleteMapping("/deleteParking/{id}")
    public ResponseEntity<String> deleteParking(
            @PathVariable Long id
    )
    {
        parkingLotService.deleteParkingLot(id);
        return ResponseEntity.ok("Delete new employee successful");
    }
}
