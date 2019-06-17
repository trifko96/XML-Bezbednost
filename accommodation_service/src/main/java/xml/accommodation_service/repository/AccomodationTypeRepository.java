package xml.accommodation_service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eureka.model.eurekamodel.model.AccommodationType;

public interface AccomodationTypeRepository extends JpaRepository<AccommodationType, Long> {

	public AccommodationType save(AccommodationType acc);
	
	public AccommodationType findTypeByName(String name);
	
	public List<AccommodationType> findAll();
	
	@Transactional
	@Modifying
	@Query("delete from AccomodationType where id = :id")
	public void delete(@Param("id") long id);
}
