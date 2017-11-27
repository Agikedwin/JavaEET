package sampleApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sampleApp.dao.UsersRepository;
import sampleApp.models.Users;

@Service
@Transactional
public class UsersService {
	
	private final UsersRepository userRepository;
	
	public UsersService(UsersRepository userRepository) {
		this.userRepository= userRepository;
	}
	
	public List<Users> findAll(){
		List<Users> users= new ArrayList();
		for(Users user : userRepository.findAll()) {
			users.add(user);
			String myuser= user.getUsername();
			System.out.println("this the obtained user: "+myuser);
		}
		
		return users;
	}
	
	
	public void save(Users user) {
		 System.out.println("At save service user ");
		userRepository.save(user);
	}
	
	public Users findUser(int id) {
		return userRepository.findOne(id);
	}
	
	public void delete(int id) {
		userRepository.delete(id);
	}
	
	public String findLogin(String username){
		boolean loginStaus=false;
		List<Users> users= new ArrayList();
		for(Users user : userRepository.findAll()) {
			users.add(user);
			String myuser= user.getUsername();
			if(user.getUsername().equals(username)) {
				System.out.println("user found: "+username+"  "+myuser);
				loginStaus=true;
				break;
				
			}else {
				System.out.println("user not  found: "+username+"  "+myuser);
				loginStaus=false;
			}
		}
		String msg="";
		if(loginStaus) {
			msg="success............";
		}else {
			msg="failed...........";
		}
		
		return msg;
	}
	
}
