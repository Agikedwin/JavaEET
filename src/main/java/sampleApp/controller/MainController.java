package sampleApp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sampleApp.models.Tasks;
import sampleApp.models.Users;
import sampleApp.service.TaskService;
import sampleApp.service.UsersService;

@Controller

public class MainController {	
	
	 @Autowired
	 @Qualifier(value = "taskService")
	 private TaskService taskService;

	  @Autowired
	  @Qualifier(value = "usersService")
	  private UsersService usersService;
	
	 
	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		 System.out.println("reached root dir ");
		request.setAttribute("mode", "MODE_HOME");
		request.setAttribute("auth", "MODE_YES");
		
		return "index";
	}

	@GetMapping("/alltasks")
	public String allTasks(HttpServletRequest request) {
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("auth", "MODE_YES");
		return "index";
	}
	
	@GetMapping("/newtask")
	public String newTasks(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		request.setAttribute("auth", "MODE_YES");
		return "index";
	}
	
	@PostMapping("/savetask")
	public String saveTasks(@ModelAttribute Tasks task,BindingResult bindingResult, HttpServletRequest request) {
		task.setDate_created(new Date());
		System.out.println("show tasks........... info v "+task);
		taskService.save(task);
		request.setAttribute("task", taskService.findAll());
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("auth", "MODE_YES");
		return "redirect: index";
	}
	
	@GetMapping("/updatetask")
	public String updateTasks(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("task", taskService.findTask(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("auth", "MODE_YES");
		return "index";
	}
	
	@GetMapping("/deletetask")
	public String deleteTasks(@RequestParam int id, HttpServletRequest request) {
		taskService.delete(id);
		request.setAttribute("task", taskService.findAll());
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("auth", "MODE_YES");
		return "index";
	}
	
	/*Users Controller Mapping*/
	
	@GetMapping("/allusers")
	public String allUsers(HttpServletRequest request) {
		request.setAttribute("users", usersService.findAll());
		request.setAttribute("mode", "MODE_ALLUSERS");
		return "index";
	}
	
	@GetMapping("/newuser")
	public String newUser(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEWUSER");
		return "index";
	}
	
	@PostMapping("/saveuser")
	public String saveUsers(@ModelAttribute Users user,BindingResult bindingResult, HttpServletRequest request) {
		System.out.println("show user info v "+user);
		//usersService.save(user);
		request.setAttribute("user", usersService.findAll());
		request.setAttribute("mode", "MODE_ADDUSER");
		return "index";
	}
	
	@GetMapping("/viewusers")
	public String addusers(HttpServletRequest request) {
		 System.out.println("reached root View users ");
		request.setAttribute("mode", "MODE_VIEWUSERS");
		return "index";
	}
	
	 @GetMapping("/")
		public String login(HttpServletRequest request) {
			 System.out.println("reached root login ");
			request.setAttribute("mode", "MODE_LOGIN");
			request.setAttribute("auth", "MODE_NO");
			
			return "index";
		}
	
	@PostMapping("/login")
	public String userlogin(@RequestParam String username, HttpServletRequest request) {
		
		request.setAttribute("user", usersService.findLogin(username));
		String myuser= usersService.findLogin(username);
		System.out.println("login status  "+myuser);
		//request.setAttribute("mode", "MODE_USERLOGIN");
		if(myuser.equals("success")) {
			//request.setAttribute("mode", "MODE_USERLOGIN");
		}else {
			//request.setAttribute("mode", "MODE_LOGIN");
		}
		
		
		return "index";
	}
	
	
	

}
