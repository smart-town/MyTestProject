package smalltown.repository;

import smalltown.model.User;

public interface UserRepository {
	public User getUserById(String id) ;
	public int deleteUserById(String id) ;
	public int updateUserById(String id) ;
	public int addUserById(User user) ;
}
