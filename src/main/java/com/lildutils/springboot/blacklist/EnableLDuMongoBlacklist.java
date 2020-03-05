package com.lildutils.springboot.blacklist;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.lildutils.springboot.blacklist.mongodb.config.LDuMongoBlacklistConfigurer;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(LDuMongoBlacklistConfigurer.class)
public @interface EnableLDuMongoBlacklist
{

}
