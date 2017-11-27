package sampleApp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sampleApp.models.Tasks;
import sampleApp.service.TaskService;

@RestController
public class SampleRestController {
  
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/hell0")
	public String hello() {
	  return "Hello world  ";
  }
	
	/*@GetMapping("/tasks")
	public String AllTasks() {
		return taskService.findAll().toString();
	}
	
	@GetMapping("/save")
	public String saveTasks(@RequestParam String name,@RequestParam String desc) {
		Tasks task=new Tasks(name,desc, new Date(), false);
		taskService.save(task);
		return "task Successfully save";
		
	}
	
	@GetMapping("delete")
	public String saveTasks(@RequestParam int id) {
		
		taskService.delete(id);
		return "task Successfully deleted";
		
	}*/
}
