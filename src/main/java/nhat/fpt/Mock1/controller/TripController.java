package nhat.fpt.Mock1.controller;

import nhat.fpt.Mock1.model.dto.BookingOfficeDTO;
import nhat.fpt.Mock1.model.dto.TripDTO;
import nhat.fpt.Mock1.model.entity.Trip;
import nhat.fpt.Mock1.model.response.BookingOfficeResponse;
import nhat.fpt.Mock1.model.response.TripResponse;
import nhat.fpt.Mock1.repository.TripRepository;
import nhat.fpt.Mock1.service.BookingOfficeService;
import nhat.fpt.Mock1.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TripResponse>> findAllTrip(){
        return ResponseEntity.ok(tripService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TripResponse> findOffice(
            @RequestParam(name = "officeId") Long id
    ){
        return ResponseEntity.ok(tripService.findById(id));
    }

    @PostMapping("/addTrip")
    public ResponseEntity<String> addTrip(
            @RequestBody TripDTO updateTripDTO)
    {
        tripService.addTrip(updateTripDTO);
        return ResponseEntity.ok("Add new trip successful");
    }

    @PutMapping("/updateTrip/{id}")
    public ResponseEntity<TripResponse> updateById(
            @PathVariable Long id,
            @RequestBody TripDTO updateTripDTO
    )
    {
        return ResponseEntity.ok(tripService.updateTrip(id,updateTripDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable Long id
    )
    {
        tripService.deleteTrip(id);
        return ResponseEntity.ok("Deleted Trip!");
    }
}
