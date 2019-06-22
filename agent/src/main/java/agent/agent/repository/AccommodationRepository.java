package agent.agent.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import agent.agent.model.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

	public Accommodation save(Accommodation acc);
	
	public Accommodation findAccommodationByName(String name);
	
	@Query("select accommodation from Accommodation accommodation where accommodation.agent.id = :id")
	public List<Accommodation> getAllAccommodations(@Param("id") long id);
	
	public Accommodation findOneByAccommodationId(long id);
	
	@Transactional
	@Modifying
	@Query("update Accommodation accommodation set accommodation.status = agent.agent.model.AccommodationStatus.RESERVED where accommodation.accommodationId = :id")
	public void reserveAcc(@Param("id") long id);
	
	
}
