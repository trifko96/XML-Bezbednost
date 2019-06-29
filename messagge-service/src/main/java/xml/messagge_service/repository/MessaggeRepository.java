package xml.messagge_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eureka.model.eurekamodel.model.Messagge;

public interface MessaggeRepository extends JpaRepository<Messagge, Long> {

	@Query("select messagge from Messagge messagge where messagge.send.username = :username")
	public List<Messagge> getSentMessagges(@Param("username") String username);
	
	@Query("select messagge from Messagge messagge where messagge.receive.username = :username")
	public List<Messagge> getReceivedMessagges(@Param("username") String username);
}
