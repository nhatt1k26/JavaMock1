package nhat.fpt.Mock1.repository;

import nhat.fpt.Mock1.model.entity.BookingOffice;
import nhat.fpt.Mock1.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    Optional<Car> findByLicensePlate(String LicensePlate);
    boolean existsByLicensePlate(String License);
}
