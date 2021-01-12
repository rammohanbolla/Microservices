package com.usk.demo.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select new com.usk.demo.dto.UserResponseDto(u.firstName, count(u)) from User u where u.firstName=:firstName")
	List<UserResponseDto> getUserResponseDto(@Param("firstName") String firstName);
	
	List<User> findByFirstName(String firstName);
	
	List<User> findByFirstNameContains(String firstName);
	
	List<User> findByFirstNameContainsOrderByFirstNameAsc(String firstName);
	
	List<User> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<User> findByFirstNameOrLastName(String firstName, String lastName);
	
	@Query("from User u where u.firstName=:firstName and u.lastName=:lastName")
	List<User> getUser(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Query(value = "select u.* from user u where u.first_name=:firstName", nativeQuery = true)
	List<User> getData(@Param("firstName") String firstName);
	
	//@Query("select u.id, u.age from User u where u.firstName=:firstName and u.lastName=:lastName")
	//List<?> getCustomUser(@Param("firstName") String firstName, @Param("lastName") String lastName);
 
}
