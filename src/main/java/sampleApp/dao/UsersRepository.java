package sampleApp.dao;

import org.springframework.data.repository.CrudRepository;

import sampleApp.models.Users;

public interface UsersRepository extends CrudRepository<Users,Integer> {

}
