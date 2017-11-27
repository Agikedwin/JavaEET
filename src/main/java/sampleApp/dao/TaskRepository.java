package sampleApp.dao;



import org.springframework.data.repository.CrudRepository;


import sampleApp.models.Tasks;



public interface TaskRepository extends CrudRepository<Tasks, Integer> {
	
	

}
