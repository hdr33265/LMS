package studio.hdr.lms.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateHelper {
	public static List<String> latestYears = new ArrayList<String>(8);
	public static List<String> birthYears = new ArrayList<String>(100);
	public static List<String> months = new ArrayList<String>(12);
//	public static List<Integer> bigMonths=new ArrayList<Integer>(7);
	public static List<Integer> smallMonths=new ArrayList<Integer>(4);
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
	static {
		Calendar rightNow = Calendar.getInstance();
		int now = rightNow.get(Calendar.YEAR);
		for (int i = 0; i < 8; i++) {
			latestYears.add(String.valueOf(now - i));
		}
		for (int i = 0; i < 60; i++) {
			birthYears.add(String.valueOf(now - i - 10));
		}
		for (int i = 1; i < 13; i++) {
			months.add(String.valueOf(i));
		}
	
		smallMonths.add(4);
		smallMonths.add(6);
		smallMonths.add(9);
		smallMonths.add(11);
	}

	public static List<String>  getDays(int year,int month) {
		List<String> days=null;
		int count=0;
		if(smallMonths.contains(month)){
			count=30;
		}else if(month!=2){
			count=31;
		}else{
			if((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0))
				count=29;
			else count=28;
		}
		days=new ArrayList<String>(count);
		for(int i=1;i<=count;i++){
			days.add(String.valueOf(i));
		}
		return days;
	}
	
	public static String formatDate(Date date){
		return sdf.format(date);
	}
	
	public static Date getDeadline(Date borrowDate,int d){
		Calendar bDate = Calendar.getInstance();
		bDate.clear();
		bDate.setTime(borrowDate);
		bDate.add(Calendar.DATE, d);
		return bDate.getTime();
	}
}
