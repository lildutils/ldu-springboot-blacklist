package com.lildutils.springboot.blacklist.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.lildutils.springboot.blacklist.mongodb.repository.LDuMongoBlacklistRepository;
import com.lildutils.springboot.blacklist.mongodb.service.LDuMongoBlacklistService;

@Configuration
//TODO [lildworks] FEAT: Enable SpringBoot AutoConfigurer for EntityScan	
//@EntityScan(basePackageClasses = LDuMongoBlacklistItem.class)
@EnableMongoRepositories(basePackageClasses = LDuMongoBlacklistRepository.class)
@ComponentScan(basePackageClasses = LDuMongoBlacklistService.class)
public class LDuMongoBlacklistConfigurer
{

}
