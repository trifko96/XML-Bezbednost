package agent.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import agent.agent.model.AccommodationService;

public interface AccommodationServiceRepository extends JpaRepository<AccommodationService, Long> {

	public List<AccommodationService> findAll();
}
