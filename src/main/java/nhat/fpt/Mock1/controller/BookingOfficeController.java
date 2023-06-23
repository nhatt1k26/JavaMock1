package nhat.fpt.Mock1.controller;

import nhat.fpt.Mock1.model.dto.BookingOfficeDTO;
import nhat.fpt.Mock1.model.response.BookingOfficeResponse;
import nhat.fpt.Mock1.service.BookingOfficeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookingOffice")
public class BookingOfficeController {
    private final BookingOfficeService bookingOfficeService;
    public BookingOfficeController(BookingOfficeService bookingOfficeService){
        this.bookingOfficeService=bookingOfficeService;
    }
    @GetMapping("/all")
    public List<BookingOfficeResponse> findAllBookingOffice(){
        return bookingOfficeService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingOfficeResponse> findOffice(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(bookingOfficeService.findById(id));
    }

    @PostMapping("/addOffice")
    public ResponseEntity<String> updateById(
            @RequestBody BookingOfficeDTO newOffice
    )
    {
        bookingOfficeService.addBookingOffice(newOffice);
        return ResponseEntity.ok("Add office successful");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(
            @PathVariable Long id,
            @RequestBody BookingOfficeDTO updateBookingOffice)
    {
        bookingOfficeService.updateBookingOffice(id,updateBookingOffice);
        return ResponseEntity.ok("Update succesfful");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable Long id
    )
    {
        bookingOfficeService.deleteBookingOffice(id);
        return ResponseEntity.ok("Deleted book trip!");
    }
}
