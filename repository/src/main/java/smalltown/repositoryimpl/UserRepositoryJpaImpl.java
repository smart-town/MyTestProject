package smalltown.repositoryimpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smalltown.model.User;
import smalltown.repository.UserRepository;

@Repository
@Qualifier("UserJap")
@Transactional
public class UserRepositoryJpaImpl implements UserRepository {
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public User getUserById(String id) {
		emf.createEntityManager().find(User.class, Integer.parseInt(id)) ;
		return null;
	}

	@Override
	public int deleteUserById(String id) {
		return 0;
	}

	@Override
	public int updateUserById(String id) {
		return 0;
	}

	@Override
	public int addUserById(User user) {
		return 0;
	}

}
