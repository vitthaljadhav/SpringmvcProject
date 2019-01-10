package com.info.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.info.mvc.entity.Project;
import com.info.mvc.service.ProjectService;

@Controller
public class HomeController {
	@Autowired
    ProjectService projectService;
	
	
	@RequestMapping(value="/",params="projectId")
	public String goHome(Model model,@RequestParam("projectId") Long projectId)
	{
		projectService.find(projectId);
		model.addAttribute("currentProject",projectService.find(projectId));
		return "home";
		
	}
	
	/*   //this a RedirectAttribute
	@RequestMapping(value="/",params="projectId")
	public String goRedirectAttribute(Model model,@RequestParam("projectId") Long projectId)
	{
		projectService.find(projectId);
		model.addAttribute("currentProject",projectService.find(projectId));
		return "home";
		
	}
	*/
	@RequestMapping(value="/")
	public String goFlushAttribute(Model model,@ModelAttribute("project") Project project)
	{
		model.addAttribute("currentProject",project);
		return "home";
	}
	
	
	/*
	@RequestMapping(value="/")
	public String gohome(Model model)
	{
		Project project = new Project();
		project.setName("Transaction Managenent");
		//project.setSponsor("This project sponosr by NASA");
		project.setDescription("This project is very importat for Every Country....Plz Keep that more copy of That Project");
		
		model.addAttribute("projectInfo",project);
		return "welcome";
	}*/
}
