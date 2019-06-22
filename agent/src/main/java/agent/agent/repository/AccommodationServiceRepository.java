package agent.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import agent.agent.model.AccommodationService;

public interface AccommodationServiceRepository extends JpaRepository<AccommodationService, Long> {

	public List<AccommodationService> findAll();
	
	@Query("select accommodationService from Accommodation accommodation where accommodation.accommodationId = :id")
	public List<AccommodationService> getServicesByUnit(@Param("id") long id);
	
}
