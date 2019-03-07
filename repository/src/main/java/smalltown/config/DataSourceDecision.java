package smalltown.config;

import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotatedTypeMetadata;

//@PropertySource("classpath:dbconfig.properties") 此处声明似乎没啥用，得到的 Env 没用。
public class DataSourceDecision implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment() ;
		String mode = null ;

		try {
			Properties prop = PropertiesLoaderUtils.loadAllProperties("dbconfig.properties") ;
			mode = prop.getProperty("pattern") ;
		} catch(Exception e){
			e.printStackTrace() ;

		}
		mode = env.getProperty("pattern") == null ? mode : env.getProperty("pattern") ;
		mode = mode == null ? "embeded" : mode;

		String annotate = "org.springframework.beans.factory.annotation.Qualifier";
		if(metadata.isAnnotated(annotate)) {
			Map<String,Object> values = metadata.getAnnotationAttributes(annotate) ;
			if(values.get("value").equals(mode)){
				System.out.println("*****环境设置模式："+mode+"-》加载对应的 dataSource");
				return true;
			}
		}
		return false;
	}

}
