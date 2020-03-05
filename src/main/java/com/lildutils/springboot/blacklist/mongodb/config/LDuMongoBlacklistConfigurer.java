package com.lildutils.springboot.blacklist.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.lildutils.springboot.blacklist.mongodb.repository.LDuMongoBlacklistRepository;
import com.lildutils.springboot.blacklist.mongodb.service.LDuMongoBlacklistService;
import com.lildutils.springboot.blacklist.validation.validator.LDuBlacklistItemValidtor;

/**
 * NOTE: This should be add in the root project<br>
 * <b>@EntityScan(basePackageClasses = LDuMongoBlacklistItem.class)</b>
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = LDuMongoBlacklistRepository.class)
@ComponentScan(basePackageClasses =
{ LDuMongoBlacklistService.class, LDuBlacklistItemValidtor.class })
public class LDuMongoBlacklistConfigurer
{

}
