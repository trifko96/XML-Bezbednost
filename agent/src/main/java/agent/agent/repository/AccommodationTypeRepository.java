package agent.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import agent.agent.model.AccommodationType;

public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, Long> {

	public List<AccommodationType> findAll();
}
