package johnc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import johnc.model.Insurer;

public interface InsurerRepository extends JpaRepository<Insurer, Long> {
	Insurer findInsurerByCode(String code);
}
