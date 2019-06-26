package agent.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import agent.agent.model.Messagge;

public interface MessaggeRepository extends JpaRepository<Messagge, Long> {

	@Query("select messagge from Messagge messagge where messagge.receive.username = :username")
	public List<Messagge> getMessagge(@Param("username") String username);
}
