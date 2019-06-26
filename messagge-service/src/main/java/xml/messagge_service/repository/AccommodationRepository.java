package xml.messagge_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eureka.model.eurekamodel.model.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

	@Query("select accommodation from Accommodation accommodation where accommodation.name = :name")
	public Accommodation findByName(@Param("name") String name);
}
