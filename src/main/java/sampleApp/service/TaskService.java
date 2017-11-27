package sampleApp.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import sampleApp.dao.TaskRepository;
import sampleApp.models.Tasks;


@Service
@Transactional
public class TaskService {
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
	this.taskRepository = taskRepository;
	
	
	}
	
	public List<Tasks> findAll(){
		List<Tasks> tasks= new ArrayList();
		for(Tasks task : taskRepository.findAll()) {
			tasks.add(task);
		}
		return tasks;
	}
	
	
	public void save(Tasks task) {
		taskRepository.save(task);
	}
	
	public Tasks findTask(int id) {
		return taskRepository.findOne(id);
	}
	
	public void delete(int id) {
		taskRepository.delete(id);
	}

}
