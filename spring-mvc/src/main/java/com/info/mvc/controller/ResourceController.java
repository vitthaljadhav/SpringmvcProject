package com.info.mvc.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.info.mvc.entity.Resource;
import com.info.mvc.service.ResourceService;


@Controller
@RequestMapping(value="/resource")
@SessionAttributes(value="resource")
public class ResourceController {
	
	@Autowired
	private ResourceService service;
     @RequestMapping("/{resourceId}")
    @ResponseBody
	public Resource findByResourcesId(@PathVariable("resourceId") Long resourceId)
	{
		return service.find(resourceId);
	}
	
	@RequestMapping(value="/find")
	public String findResource(Model model)
	{
		model.addAttribute("resources", service.findAll());
		return "resources";
	}

	@RequestMapping(value="/request")
	@ResponseBody
	public String request()
	{
		return "this request has been sent";
	}
	
	/*@ExceptionHandler(NullPointerException.class)
	public String handleException(HttpServletRequest request)
	{
		return "controller_error";	
	}*/
	
	@RequestMapping(value="/add")
	public String addResource(Model model)
	{
		/*if(1==1)
		{
			throw new RuntimeException("There was a Error");
		}
		System.out.println("invoking addResource() method");*/
		return "resource_add";	
	}
	
	@RequestMapping(value="/review")
	//public String review(@ModelAttribute("resource")Resource resource)
	public String review(@RequestBody String resource)
	{
		System.out.println(resource);
		System.out.println("Invoking review() method");
		return "resource_review";
	}
	
	@ModelAttribute(value="resource")
	public Resource getResources()
	{
		System.out.println("here create new Instance of Resource PoJo class");
		return new Resource();
	}
	
	@ModelAttribute(value="typeOptions")
	public List<String> getType()
	{
		return new LinkedList<>(Arrays.asList(new String[] {"Material","Other","Staff","Technical Equipment"}));
	}
	
	@ModelAttribute("radioOptions")
	public List<String> getRadiosOptions()
	{
		return new LinkedList<>(Arrays.asList(new String[]{
				"Hours", "Piece", "Tons"	
			}));
	}
	
	@ModelAttribute(value="checkOptions")
	public List<String> getCheckOptions()
	{
		return new ArrayList<>(Arrays.asList(new String[] {"Lead Time", "Special Rate", "Requires Approval"}));
	}
	
	@RequestMapping(value="/save")
	public String saveResouce(@ModelAttribute("resource") Resource resource,SessionStatus sessionStatus)
	{
	
		System.out.println("invoking saveResouce() method");
		System.out.println(resource);
		sessionStatus.setComplete();
		return "redirect:/resource/add";	
	}
		
	
	
	
	
	/*	@RequestMapping(value="/add")
	public String addResource(Model model)
	{
		List<String> typeOptions=new LinkedList<>(Arrays.asList(new String[] {
				"Material","Other","Staff","Technical Equipment"}));
						model.addAttribute("typeOptions", typeOptions);
		
		//List<String> options=Arrays.asList("Material","Other","Staff","Technical Equipment");

		List<String> radios = new LinkedList<>(Arrays.asList(new String[]{
				"Hours", "Piece", "Tons"	
			}));
			model.addAttribute("radioOptions", radios);
			
			List<String> checks = new LinkedList<>(Arrays.asList(new String[]{
				"Lead Time", "Special Rate", "Requires Approval"	
			}));
			model.addAttribute("checkOptions", checks);
			

	
		model.addAttribute("resource", new Resource());
		System.out.println("invoking addResource() method");
		return "resource_add";	
	}*/
}
