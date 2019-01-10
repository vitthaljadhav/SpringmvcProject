package com.telusko.tusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.tusko.dao.FeedbackDao;
import com.telusko.tusko.entity.Feedback;

@Controller
public class IndexController {

	@Autowired
	FeedbackDao fdao;
	
	Feedback feedback;
	
	@RequestMapping(value="/")
	public String home()
	{
		return "index.jsp";
	}
	
	@RequestMapping(value="/feedback")
	public String feedback()
	{
		return "feedback.jsp";
	}
	
	@RequestMapping(value="/addFeedback")
	//public String addFeedack(@RequestParam("name")String name,@RequestParam("email")String email, @RequestParam("reg")String reg, @RequestParam("code")int code,@RequestParam("message")String message,@RequestParam("rating") int rating)
	
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback) 
	{	
		//feedback=new Feedback(name, email, reg, message, code, rating);
		fdao.addfeedback(feedback);
		return "welcome.jsp";
	}
	@RequestMapping(value="/getFeedback")
	public ModelAndView getFeedback( Feedback feedback)
	{
		ModelAndView modelAndView=new ModelAndView("feedbacks.jsp");
		
		modelAndView.addObject("feedbacks", fdao.getFeedback());
		
		return modelAndView;
	}	
	
	@RequestMapping(value="/question")
	public ModelAndView addQuestion(@ModelAttribute("feedback") Feedback feedback)
	{
		ModelAndView modelAndView=new ModelAndView("question.jsp");
		return modelAndView;
	}

}
 