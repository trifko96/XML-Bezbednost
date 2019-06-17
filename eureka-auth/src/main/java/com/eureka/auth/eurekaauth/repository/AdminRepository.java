package com.eureka.auth.eurekaauth.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eureka.model.eurekamodel.model.User;
import com.eureka.model.eurekamodel.model.UserRole;

public interface AdminRepository extends JpaRepository<User, Long> {

	public User save(User user);
	
	public User findUserByUsername(String username);
	
	@Transactional
	@Modifying
	@Query("update User user set user.status = com.eureka.model.eurekamodel.model.UserStatus.ACTIVATED where user.userId = :id")
	public void activateUser(@Param("id") long id);
	
	public User findUserByUserId(long id);
	
	public List<User> findUserByRole(UserRole role);
	
	@Transactional
	@Modifying
	@Query("update User user set user.status = com.eureka.model.eurekamodel.model.UserStatus.BLOCKED where user.userId = :id")
	public void blockUser(@Param("id") long id);
	
	@Transactional
	@Modifying
	@Query("delete from User where userId = :id")
	public void delete(@Param("id") long id);
}
