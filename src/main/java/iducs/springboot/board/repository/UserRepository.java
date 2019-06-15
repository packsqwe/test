package iducs.springboot.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import iducs.springboot.board.entity.UserEntity;


public interface UserRepository 
	extends JpaRepository<UserEntity, Long> {	
	UserEntity findByUserId(String userId);
	public List<UserEntity> findByNameOrderByIdAsc(String name);
	public List<UserEntity> findByCompany(String company);

}
