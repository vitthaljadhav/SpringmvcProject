package com.info.mvc.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.info.mvc.entity.Project;
import com.info.mvc.service.ProjectService;
import com.info.mvc.validator.ProjectValidator;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	// redirect Attribute
	/*@RequestMapping(value="/test")
	public String redirectConcep()
	{
		return "redirect:/";
		
	}*/
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProjectValidator());
	}

	@RequestMapping(value = "find/{projectId}")
	public @ResponseBody Project findprojectXmlOrJsonFrmat(Model model, @PathVariable("projectId") Long projectId) {
		return projectService.find(projectId);
	}
	
	@RequestMapping(value = "/{projectId}")
	public String findproject(Model model, @PathVariable("projectId") Long projectId) {
		Project project = projectService.find(projectId);
		model.addAttribute("project", project);
		return "project";
	}

	@RequestMapping(value = "/find")
	public String find(Model model) {
		model.addAttribute("projects", projectService.findAll());
		return "projects";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("type", new ArrayList<String>() {
			{
				add("");
				add("Single Year");
				add("Multi-Year");
			}
		});
		model.addAttribute("project", new Project());
		return "project_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute("project") Project project, Errors error,
			RedirectAttributes attributes) {
		    project.setProjectId(55L);
		this.projectService.save(project);
		//attributes.addAttribute("projectId", project.getProjectId().toString());	
		attributes.addFlashAttribute("project", project);
		System.out.println(project);
		return "redirect:/";
	}

	/*
	 * @RequestMapping(value = "/add", method = RequestMethod.POST) public String
	 * saveProject(@RequestParam("name") String name, HttpSession session ) {
	 * System.out.println(session.getAttribute("token"));
	 * //System.out.println(request.getParameter("name")); System.out.println(name);
	 * System.out.println("invoking saveproject()"); return "project_add"; }
	 * 
	 * @RequestMapping(value = "/add", method = RequestMethod.GET) public String
	 * addProject(HttpSession session) { session.setAttribute("token", "12345");
	 * System.out.println("Invoking addproject()"); return "project_add"; }
	 * 
	 * 
	 * @RequestMapping(value = "/add", method = RequestMethod.POST, params = {
	 * "type=multi" }) public String saveMultiProject() {
	 * System.out.println("invoking multiproject()"); return "project_add"; }
	 * 
	 * @RequestMapping(value = "/add", method = RequestMethod.POST, params = {
	 * "type=multi", "special" }) public String saveSpecialProject() {
	 * System.out.println("invoking saveSpecialProject()"); return "project_add"; }
	 */
}
