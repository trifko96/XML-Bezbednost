package agent.agent.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import agent.agent.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("select reservation from Reservation reservation where reservation.accommodation.accommodationId = :id")
	public List<Reservation> getReservations(@Param("id") long id);
	
	@Transactional
	@Modifying
	@Query("update Reservation reservation set reservation.status = agent.agent.model.ReservationStatus.APPROVED where reservation.id = :id")
	public void approveRes(@Param("id") long id);
	
	@Transactional
	@Modifying
	@Query("update Reservation reservation set reservation.status = agent.agent.model.ReservationStatus.REJECTED where reservation.id = :id")
	public void rejectRes(@Param("id") long id);
}
