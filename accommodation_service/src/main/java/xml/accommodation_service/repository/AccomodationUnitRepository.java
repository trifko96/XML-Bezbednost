package xml.accommodation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.model.eurekamodel.model.Accommodation;

public interface AccomodationUnitRepository extends JpaRepository<Accommodation, Long> {

}
