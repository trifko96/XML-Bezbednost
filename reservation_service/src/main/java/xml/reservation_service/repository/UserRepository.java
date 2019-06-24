package xml.reservation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.model.eurekamodel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findUserByUsername(String username);
}
