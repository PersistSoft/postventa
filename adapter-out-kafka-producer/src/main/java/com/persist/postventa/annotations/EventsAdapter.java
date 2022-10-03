package com.persist.postventa.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventsAdapter {
    @AliasFor(annotation = Component.class)
    String value() default "Events Adapter";
}
