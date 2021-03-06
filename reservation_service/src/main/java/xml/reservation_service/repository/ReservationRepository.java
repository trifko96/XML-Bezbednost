package xml.reservation_service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eureka.model.eurekamodel.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("select reservation from Reservation reservation where reservation.user.username = :username")
	public List<Reservation> getReservationsByUser(@Param("username") String username);
	
	@Query("select reservation from Reservation reservation where reservation.id = :id")
	public Reservation getReservationById(@Param("id") long id);

	@Transactional
	@Modifying
	@Query("delete from Reservation where id = :id")
	public void deleteReservation(@Param("id") long id);

}
