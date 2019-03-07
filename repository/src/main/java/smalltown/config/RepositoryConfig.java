package smalltown.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import smalltown.entity.EntityScanFlag;
import smalltown.repository.RepositoryScanFlag;
import smalltown.repositoryimpl.RepositoryImplScanFlag;

@Configuration
@ComponentScan(basePackageClasses={RepositoryScanFlag.class,RepositoryImplScanFlag.class,EntityScanFlag.class},basePackages={"smalltown.config"})
@Import(JdbcConfig.class)
public class RepositoryConfig {

}
