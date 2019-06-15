package iducs.springboot.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iducs.springboot.board.domain.User;
import iducs.springboot.board.entity.UserEntity;
import iducs.springboot.board.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired UserRepository repository;

	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public User getUserByUserId(String userId) {
		System.out.println(userId);
		UserEntity userEntity = repository.findByUserId(userId);
		System.out.println(userEntity.toString());
		return userEntity.buildDomain();
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		List<UserEntity> entities = repository.findAll();
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}
		return users;
	}

	@Override
	public List<User> getUsersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByPage(int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		entity.buildEntity(user);
		repository.save(entity);
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		
	}

	
		
}
