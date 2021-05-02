package johnc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import johnc.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
