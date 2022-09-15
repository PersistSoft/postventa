package com.persist.postventa.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebAPIRESTAdaptar {

	@AliasFor(annotation = Component.class)
	  String value() default "Web API REST Adaptar";
}
