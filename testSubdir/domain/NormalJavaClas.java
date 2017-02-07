package com.splwg.cm.domain.SQL;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeMap;

import com.ibm.icu.text.SimpleDateFormat;
import com.splwg.base.api.GenericBusinessObject;
import com.splwg.base.api.datatypes.DateFormat;
import com.splwg.base.api.datatypes.DateTime;
import com.splwg.base.domain.systemDateTime.GetSystemDateTimeService;

public class NormalJavaClas   {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		String regex = "\\d+",noOfdays;
		noOfdays="12.0";
		
		System.out.println(noOfdays.matches(regex));
		
 	// System.out.println( QuarterStartDate(new DateTime(2016,05, 23),0 ));
 
	// 	System.out.println( QuarterEnddate(new DateTime(2016, 05, 23),0 ));
		
	/*	Calendar calendar = Calendar.getInstance();
		int yearpart = 2016;
		int monthPart = 10;
		int dateDay = 1;
		calendar.set(yearpart, monthPart, dateDay);
		int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("Number of Days: " + numOfDaysInMonth);
		System.out.println("First Day of month: " + calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth-1);
		System.out.println("Last Day of month: " + calendar.getTime());	*/
		/*
	    Calendar calendar = Calendar.getInstance();
	    int yearpart = new Date().getYear();
	    int monthPart =  new Date().getMonth();
	    int dateDay =  new Date().getDay();
	    System.out.println("yearpart  "+yearpart+"   monthPart  "+monthPart +"  dateDay  "+dateDay);
	    
	    calendar.set(yearpart, monthPart, dateDay);
	    int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
 
	    System.out.println("First Day of month: " + new Date(calendar.getTime().getYear(),calendar.getTime().getMonth(),calendar.getTime().getDate() ));
	    calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth-1);*/
	/*java.util.Date endDate;	
 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
		Calendar c=Calendar.getInstance();
		
	 
	 
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate=c.getTime();	
		endDate	=new Date(sdf.format(endDate));
		
		
		System.out.println(endDate);
		;*/
		TreeMap <String, String> ma=new TreeMap <String, String>();
		ma.put("CURRENCY","USD");
		ma.put("COUNTR","US");
		ma.put("BILLINGLINE", "BL1");
		
		
		
		String p="",s;
		 for( String keyS: ma.keySet())
		 {
			 s=keyS.concat("~").concat(ma.get(keyS));
			 p=p.concat(s);
		//	 System.out.println("last key "+ma.lastKey());
			 
			 if(!ma.lastKey().equals(keyS))
				 p=p.concat("=");
			 
			 
		 }
		System.out.println(p);
		
	}
	public static DateTime QuarterEnddate(DateTime curDate, int whichQtr )
	{
	   int tQtr = (curDate.getMonth() - 1) / 3 + 1 + whichQtr;
	   return new DateTime(curDate.getYear(), (tQtr * 3) + 1, 1).addDays(-1);
	}
	 
	public static DateTime QuarterStartDate(DateTime curDate, int whichQtr )
	{
	   return QuarterEnddate(curDate, whichQtr).addDays(1).addMonths(-3);
	}
}
