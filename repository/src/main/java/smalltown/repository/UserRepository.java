package smalltown.repository;

import org.springframework.cache.annotation.Cacheable;

import smalltown.model.User;

public interface UserRepository {
//	@Cacheable("getUserById")
	public User getUserById(String id) ;
	public int deleteUserById(String id) ;
	public int updateUserById(String id) ;
	public int addUserById(User user) ;
}
