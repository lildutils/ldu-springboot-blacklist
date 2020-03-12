package com.lildutils.springboot.blacklist.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lildutils.springboot.blacklist.jpa.repository.LDuJpaBlacklistRepository;
import com.lildutils.springboot.blacklist.jpa.service.LDuJpaBlacklistService;

@Configuration
//TODO [lildworks] FEAT: Enable SpringBoot AutoConfigurer
//@EntityScan(basePackageClasses = LDuJpaBlacklistItem.class)
@EnableJpaRepositories(basePackageClasses = LDuJpaBlacklistRepository.class)
@ComponentScan(basePackageClasses = LDuJpaBlacklistService.class)
public class LDuJpaBlacklistConfigurer
{

}
