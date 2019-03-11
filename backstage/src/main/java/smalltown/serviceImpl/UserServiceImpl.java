package smalltown.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smalltown.model.User;
import smalltown.repositoryimpl.UserRepositoryJpaAuto;
import smalltown.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepositoryJpaAuto userRepository ;

	@Override
	public User getUser(String id) {
		System.out.println("UserServiceImpl .. do service, param:" + id);
		User user = userRepository.getOne(Integer.valueOf(id)) ;
		return user;
	}
}
