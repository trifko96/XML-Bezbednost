package agent.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agent.agent.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User save(User user);
	
	public User findByUsername(String username);
}
