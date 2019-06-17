package xml.accommodation_service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eureka.model.eurekamodel.model.AccommodationService;

public interface AccomodationServiceRepository extends JpaRepository<AccommodationService, Long> {

	public AccommodationService save(AccommodationService acc);
	
	public AccommodationService findServiceByName(String name);
	
	public List<AccommodationService> findAll();
	
	@Transactional
	@Modifying
	@Query("delete from AccomodationService where id = :id")
	public void delete(@Param("id") long id);
}
