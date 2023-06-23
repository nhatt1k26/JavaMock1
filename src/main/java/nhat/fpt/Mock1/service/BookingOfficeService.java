package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.model.dto.BookingOfficeDTO;
import nhat.fpt.Mock1.model.response.BookingOfficeResponse;

import java.util.List;

public interface BookingOfficeService{
    List<BookingOfficeResponse> findAll();
    BookingOfficeResponse findById(Long id);
    BookingOfficeResponse addBookingOffice(BookingOfficeDTO newElement);
    BookingOfficeResponse updateBookingOffice(Long id,BookingOfficeDTO updateElement);
    void deleteBookingOffice(Long id);
}