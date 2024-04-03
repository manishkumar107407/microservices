package com.org.validation.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.org.validation.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	   public User findByEmailOrMobile(String Email,String Mobile);
	   public User findByEmailAndPassword(String Email, String Password);
	   
	 
	   @Query(value = "select * from user", nativeQuery = true)
	   public List<User>getUser();
	   
	   
	   

}
