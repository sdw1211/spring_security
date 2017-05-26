package kr.otawang.repository;

import org.springframework.data.repository.CrudRepository;

import kr.otawang.model.User;

public interface UserRepository extends CrudRepository<User, Long>  {
	User findById(String id);
}
