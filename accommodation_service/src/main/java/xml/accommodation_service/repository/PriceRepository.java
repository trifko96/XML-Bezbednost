package xml.accommodation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.model.eurekamodel.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
