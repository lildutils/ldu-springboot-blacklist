package com.lildutils.springboot.blacklist.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lildutils.springboot.blacklist.jpa.repository.LDuJpaBlacklistRepository;
import com.lildutils.springboot.blacklist.jpa.service.LDuJpaBlacklistService;
import com.lildutils.springboot.blacklist.validation.validator.LDuBlacklistItemValidtor;

/**
 * NOTE: This should be add in the root project<br>
 * <b>@EntityScan(basePackageClasses = LDuJpaBlacklistItem.class)</b>
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = LDuJpaBlacklistRepository.class)
@EnableTransactionManagement
@ComponentScan(basePackageClasses =
{ LDuJpaBlacklistService.class, LDuBlacklistItemValidtor.class })
public class LDuJpaBlacklistConfigurer
{

}
