package com.info.mvc.convertes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class JoiningDateConverters implements Converter<String, Date> {

	@Override
	public Date convert(String strDate) {
	
		System.out.println("Converting joining Date");
		Date tempDate=null;
		try {
			tempDate=new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		return tempDate;
	}

	

}
