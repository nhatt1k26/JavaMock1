package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.model.dto.ParkingLotDTO;
import nhat.fpt.Mock1.model.entity.ParkingLot;
import nhat.fpt.Mock1.model.response.ParkingLotResponse;
import nhat.fpt.Mock1.utilities.CustomPage;

import java.util.List;

public interface ParkingLotService {
    boolean isEmpty();
    List<ParkingLotResponse> findAll();
    ParkingLotResponse findById(Long id);
    void addParkingLot(ParkingLotDTO e);
    void updateParkingLot(Long id,ParkingLotDTO e);
    void deleteParkingLot(Long id);
}
