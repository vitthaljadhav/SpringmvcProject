package com.info.mvc.convertes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.info.mvc.entity.Resource;
import com.info.mvc.service.ResourceService;

public class ResourceConverter implements Converter<String, Resource> {

	@Autowired
	private ResourceService resourceService;
	@Override
	public Resource convert(String resourceId) {
		
		return resourceService.find(new Long(resourceId));
	}

}
