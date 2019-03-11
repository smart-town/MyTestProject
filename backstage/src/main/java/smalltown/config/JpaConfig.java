package smalltown.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:dbconfig.properties")
@EnableJpaRepositories(basePackages={"smalltown.repositoryimpl"}) //启用  Spring data JPA
public class JpaConfig implements EnvironmentAware{
	@Autowired
	Environment env ;

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		JpaTransactionManager res = new JpaTransactionManager() ;
		res.setEntityManagerFactory(entityManagerFactory);
		return res;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
		LocalContainerEntityManagerFactoryBean res = new LocalContainerEntityManagerFactoryBean();
		res.setJpaVendorAdapter(jpaVendorAdapter);
		res.setPackagesToScan(env.getProperty("jpa.scanPackages").split(","));
		res.setDataSource(dataSource);
		return res;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter() ;
		adapter.setDatabasePlatform(env.getProperty("jpa.databasePlatform")) ;
		adapter.setShowSql(true) ;
		adapter.setDatabase(Database.valueOf(env.getProperty("jpa.database")));
		adapter.setGenerateDdl(false);
		return adapter ;
	}

	@Bean //@PersistenceUnit/Context注解启用
	public PersistenceAnnotationBeanPostProcessor paPostProcessor(){
		return new PersistenceAnnotationBeanPostProcessor() ;
	}

	@Override
	public void setEnvironment(Environment arg0) {
		this.env = arg0;

	}
}
