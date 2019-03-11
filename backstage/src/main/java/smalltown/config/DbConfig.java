package smalltown.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:dbconfig.properties")
@Import({JpaConfig.class,})
public class DbConfig {
	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource() ;
		ds.setDriverClassName(env.getProperty("rdb.driver"));
		ds.setUrl(env.getProperty("rdb.url")) ;
		ds.setUsername(env.getProperty("rdb.username"));
		ds.setPassword(env.getProperty("rdb.password"));
		return  ds ;
	}

	@Bean
	public BeanPostProcessor persistenceTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
