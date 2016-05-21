package org.deepthought.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface OutoMapper {
	boolean required() default true;
}
