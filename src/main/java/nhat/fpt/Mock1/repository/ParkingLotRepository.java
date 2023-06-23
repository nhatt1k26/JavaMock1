package nhat.fpt.Mock1.repository;

import nhat.fpt.Mock1.model.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {
}
