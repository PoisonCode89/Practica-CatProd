package es.indra.demomysql.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.sql.JoinFragment;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogServiceAspect {

	@Before("execution(* es.indra.demomysql.service.impl.*.*(..))")
	public void antesDeLosMetodos(JoinFragment join) {
		System.out.println("Dentro del aspecto para: " + join);
	}

}
