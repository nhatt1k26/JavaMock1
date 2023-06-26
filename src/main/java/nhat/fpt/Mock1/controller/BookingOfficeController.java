package nhat.fpt.Mock1.controller;
import nhat.fpt.Mock1.model.dto.BookingOfficeDTO;
import nhat.fpt.Mock1.model.response.BookingOfficeResponse;
import nhat.fpt.Mock1.service.BookingOfficeService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<BookingOfficeResponse>> findAllBookingOffice(){
        if (bookingOfficeService.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(bookingOfficeService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingOfficeResponse> findOffice(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(bookingOfficeService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/addOffice")
    public ResponseEntity<String> updateById(
            @RequestBody BookingOfficeDTO newOffice
    )
    {
        bookingOfficeService.addBookingOffice(newOffice);
        return new ResponseEntity<>("Add office successful", HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(
            @PathVariable Long id,
            @RequestBody BookingOfficeDTO updateBookingOffice)
    {
        bookingOfficeService.updateBookingOffice(id,updateBookingOffice);
        return new ResponseEntity<>("Update succesfful",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable Long id
    )
    {
        bookingOfficeService.deleteBookingOffice(id);
        return new ResponseEntity<>("Deleted book trip!",HttpStatus.OK);
    }
}
