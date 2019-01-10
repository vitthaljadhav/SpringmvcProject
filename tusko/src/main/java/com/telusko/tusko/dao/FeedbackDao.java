package com.telusko.tusko.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.telusko.tusko.entity.Feedback;

@Component
public class FeedbackDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void addfeedback(Feedback feedback)
	{
		System.out.println("in addfeedback....!!!!!!!  "+feedback);
		
		Session session=sessionFactory.getCurrentSession();
		session.save(feedback);
	}
	@Transactional
	public List<Feedback> getFeedback() {
		
		String hql="from Feedback";
		Session session=sessionFactory.getCurrentSession();
		
		Query<Feedback> query = session.createQuery(hql,Feedback.class);
		
		List<Feedback> list = query.list();
		System.out.println(list);
		return list;
	}

}
