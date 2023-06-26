package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.model.dto.TripDTO;
import nhat.fpt.Mock1.model.response.TripResponse;

import java.util.List;

public interface TripService {
    boolean isEmpty();
    List<TripResponse> findAll();
    TripResponse findById(Long id);
    TripResponse addTrip(TripDTO e);
    TripResponse updateTrip(Long tripId,TripDTO e);
    void deleteTrip(Long id);
}
