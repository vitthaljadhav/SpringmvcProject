package com.telusko.tusko;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.tusko.dao.QuestionDao;
import com.telusko.tusko.entity.Question;

@Controller
public class QuestionController {
    
	int count=0;
	@Autowired
	private QuestionDao qdao;
	
	@RequestMapping(value="/saveQuestion")
	public ModelAndView saveQuestion(@ModelAttribute Question question)
	{
		ModelAndView modelAndView = new ModelAndView("printQuestion.jsp");
		qdao.saveQuestion(question);
		return modelAndView;	
	}
	@RequestMapping(value="/getNextQuestion")
	public String getNextQuestion(@RequestParam("qid") int qid)
	{
	/*	count=qid;
		if(count<=5)
		{
			
		}*/
		
		return "redirect:getQuestion";	
	}
	
	@RequestMapping(value="/getQuestion")
	public ModelAndView getQuestion()
	{	
		ModelAndView modelAndView;
		Random random = new Random();
		String a = "123456789";
		char ch = a.charAt(random.nextInt(a.length()));
		int qid = Character.getNumericValue(ch);
		Question questions = qdao.getQuestion(qid);
	
		return	modelAndView = new ModelAndView("printQuestion.jsp","questions",questions);
	}
}
