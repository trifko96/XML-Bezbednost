package agent.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import agent.agent.model.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

	public Accommodation save(Accommodation acc);
	
	public Accommodation findAccommodationByName(String name);
	
	@Query("select accommodation from Accommodation accommodation where accommodation.agent.id = :id")
	public List<Accommodation> getAllAccommodations(@Param("id") long id);
	
	
}
