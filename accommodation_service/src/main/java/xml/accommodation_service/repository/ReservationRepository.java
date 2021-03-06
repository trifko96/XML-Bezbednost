package xml.accommodation_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eureka.model.eurekamodel.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("select reservation from Reservation reservation where reservation.accommodation.name = :name")
	public List<Reservation> getReservations(@Param("name") String name);
}
