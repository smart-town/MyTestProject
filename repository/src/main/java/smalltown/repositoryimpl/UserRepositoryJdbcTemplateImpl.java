package smalltown.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import smalltown.model.User;
import smalltown.repository.UserRepository;

@Repository("JDBCTEMPLATE_USER")
@Qualifier("JdbcTemplate")
public class UserRepositoryJdbcTemplateImpl implements UserRepository {
	@Autowired
	JdbcOperations jdbcOperations;

	private static final String SELECT = "select * from user where id = ?" ;
	@Override
	public User getUserById(String id) {
		return jdbcOperations.queryForObject(SELECT,new UserRowMapper(),Integer.parseInt(id)) ;
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

	private static final class UserRowMapper implements RowMapper<User>{
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User() ;
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setStatus(rs.getInt("status"));
			return user ;
		}
	}

}
