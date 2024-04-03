package com.org.validation.serverciesImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.validation.entity.User;
import com.org.validation.repo.UserRepo;
import com.org.validation.servercies.UserService;

@Service
public class UserServiceImpl implements UserService {

@Autowired
private UserRepo userRepo;

     List<User>list;
	
public UserServiceImpl() {
		
	  list  = new ArrayList<>();
	  list.add(new User(6,"praveen","prav@gmail.com","66544658","654"));
	  list.add(new User(7,"pveen","prssav@gmail.com","6555544658","6554"));
	
}
@Override
public List<User> findByAll() {
	
//List<User> findAll = userRepo.findAll();
	return list;
}

@Override
public User findById(int id) {
	
	    User c =null;   
	for(User user : list)
	{
		if(user.getId()== id)
		{
			c =user;
			break;
		}			
	}	  
	return c;
//User user = userRepo.findById(id).get();
	
}




	@Override
	public String register(User user) {
		        
		
	   User findExitUser = this.findExitUser(user);
		
	   if(findExitUser!=null)
	   {
		   return "User is alredy exits";
	   }
	   else
	   {
		        User save = userRepo.save(user);
		        
		        return "success";
	   }   
	   
	        
	        
	   
	}

	@Override
	public User findExitUser(User user) {
		
	User findByEmailOrMobile = userRepo.findByEmailOrMobile(user.getEmail(), user.getMobile());
		         
		return findByEmailOrMobile;
	}

	@Override
	public String login(User user) {
		
	User findByEmailAndPassword = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		        
		if(findByEmailAndPassword!=null)
		{
			return "Successfull";
		}
		else {
			return "faild";
		}
	}
	
	@Override
	public User update(User user) {
		
		 User update = userRepo.save(user);
		return update;
	}
	@Override
	public void deleteUser(int id) {
		
		    userRepo.deleteById(id);
		    
	}
	@Override
	public List<User> findByUser() {
		List<User> findByName = userRepo.getUser();
		
		return findByName;
	}

              



       
		
		
	}
	
	
	
	
	
	


