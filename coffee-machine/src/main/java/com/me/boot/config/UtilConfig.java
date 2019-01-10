package com.me.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.me.boot.controller.api.CoffeeMachineResource;
import com.me.boot.util.FileStorage;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class UtilConfig  {

	private Logger log=LoggerFactory.getLogger(CoffeeMachineResource.class);
	@Autowired
	FileStorage fileStorage;
	
	@Bean
	@Profile("dev")
	public DisposableBean destroyResources() {
		log.warn("Cleaning files for profile Dev ");
		return () -> fileStorage.deleteAll(); 
	}
	
}
