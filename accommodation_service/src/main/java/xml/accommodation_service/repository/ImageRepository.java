package xml.accommodation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.model.eurekamodel.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
