package xml.messagge_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eureka.model.eurekamodel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select user from User user where user.username = :username")
	public User findByUsername(@Param("username") String username);
}
