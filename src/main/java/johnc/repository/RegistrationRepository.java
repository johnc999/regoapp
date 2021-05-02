package johnc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import johnc.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, String> {
}
