package smalltown.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * This method is used to decide whether to load the bean according to @Qualifier
 * @author smalltown
 * 
 */
@Component
@PropertySource("classpath:dbconfig.properties")
public class PersonalCondition implements Condition{
	@Autowired
	Environment env;
	
	private static final String QUALIFIER = "org.springframework.beans.factory.annotation.Qualifier";

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		boolean result = false ;                                                                                                                                                                                                               
		if(metadata.isAnnotated(QUALIFIER)) {
			String value = metadata.getAnnotationAttributes(QUALIFIER).get("value").toString() ;
			String[] values = value.split(":") ;
			if(values.length == 2) {
				switch(values[0]) {
					case "cache" : result = decideCache(values[1]); break;
					default : ;
				}
			}
		}
		return result;
	}
	
	/**
	 * decide load which Caching Configuration
	 * @param metadata
	 * @return
	 */
	public boolean decideCache(String value) {
		
		return false;
	}

}
