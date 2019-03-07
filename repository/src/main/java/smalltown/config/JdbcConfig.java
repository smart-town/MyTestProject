package smalltown.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import smalltown.entity.EntityScanFlag;
import smalltown.repository.RepositoryScanFlag;
import smalltown.repositoryimpl.RepositoryImplScanFlag;

@Configuration
@PropertySource("classpath:dbconfig.properties")
public class JdbcConfig implements EnvironmentAware{ //此处继承EnvironmentAware 是因为@Autowired Env 为 null？原因？
	@Autowired
	Environment env ;

	@Bean
	@Qualifier("jdbc")
	@Conditional(DataSourceDecision.class)
	public DataSource jdbcDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource() ;
		ds.setDriverClassName(env.getProperty("driver"));
		ds.setUrl(env.getProperty("url")) ;
		ds.setUsername(env.getProperty("username"));
		ds.setPassword(env.getProperty("password"));
		return  ds ;
	}

	@Bean
	@Qualifier("embeded")
	@Conditional(DataSourceDecision.class)
	public DataSource embeddedDataSource(){
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:sql/user.sql")
				.build();
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer() ;
	}

	@Override
	public void setEnvironment(Environment arg0) {
		this.env = arg0 ;
	}

	@Bean
	@Profile("test")
	public JdbcTemplate jdbcTemplate(@Value("${pattern}") String mode){
		System.out.println("设置 jdbcTemplate,数据源:"+mode);
		JdbcTemplate res = new JdbcTemplate() ;
		switch(mode){
			case "embeded" : res.setDataSource(embeddedDataSource()); break ;
			case "jdbc" : res.setDataSource(jdbcDataSource()); break ;
			default: ;
		}
		return res;
	}

	@Bean
	@Qualifier("embeded")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Value("${pattern}") String mode,JpaVendorAdapter jpaVendorAdapter){
		System.out.println("设置 jpa,数据源:"+mode);
		LocalContainerEntityManagerFactoryBean res = new LocalContainerEntityManagerFactoryBean();
		res.setJpaVendorAdapter(jpaVendorAdapter);
		res.setPackagesToScan(env.getProperty("jpa.scanPackages").split(","));
		switch(mode){
			case "embeded" : res.setDataSource(embeddedDataSource()); break ;
			case "jdbc" : res.setDataSource(jdbcDataSource()); break ;
			default: ;
		}
		return res;
	}
	@Bean
	@Qualifier("embeded")
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter() ;
		adapter.setDatabasePlatform(env.getProperty("jpa.databasePlatform")) ;
		adapter.setShowSql(true) ;
		adapter.setDatabase(Database.valueOf(env.getProperty("jpa.database")));
		adapter.setGenerateDdl(false);
		return adapter ;
	}
	@Bean
	@Qualifier("embeded")
	public PersistenceAnnotationBeanPostProcessor paPostProcessor(){
		return new PersistenceAnnotationBeanPostProcessor() ;
	}

	@Bean
	public BeanPostProcessor persistenceTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
