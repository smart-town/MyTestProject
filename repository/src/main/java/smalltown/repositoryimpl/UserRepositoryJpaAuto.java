package smalltown.repositoryimpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import smalltown.model.User;

//动作、主题(可选)、By、断言、限制条件
public interface UserRepositoryJpaAuto extends JpaRepository<User,Integer> {
	List<User> findByNameLike(String name);

	@Query("select u from User u where u.name like ?1 AND u.status=?2")
	List<User> findNameAndStatus(String name, int status) ;
}
