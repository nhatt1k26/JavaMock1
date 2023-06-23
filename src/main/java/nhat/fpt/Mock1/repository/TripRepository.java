package nhat.fpt.Mock1.repository;

import nhat.fpt.Mock1.model.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip,Long> {
    Optional<Trip> findByTripId(Long id);
    boolean existsByTripId(Long id);
}
