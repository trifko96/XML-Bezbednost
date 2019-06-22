package agent.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import agent.agent.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	@Query("select image.id from Image image where image.accommodation.accommodationId = :accId ")
	public List<Long> getImagesId(@Param("accId") long accId);
}
