package com.telusko.tusko.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.telusko.tusko.entity.Question;

@Component
public class QuestionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveQuestion(Question question) {
		
		Session session=sessionFactory.getCurrentSession();
				session.save(question);
	}
	
	@Transactional
	public Question getQuestion(Integer qid) {
		Session session=sessionFactory.getCurrentSession();
		Question question = session.get(Question.class, qid);
		return question;
	}

}
