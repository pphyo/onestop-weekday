package com.jdc.enm;

public class AfterEnum {
	
	public static void main(String[] args) {
		
		checkDay(null);
		
		Day[] days = Day.values();
		
		for(Day d : days) {
			System.out.println("%s : %d".formatted(d.getTitle(), d.ordinal()));
		}
		
		Day wednesday = Day.valueOf(Day.class, "WED");
		System.out.println(wednesday.getTitle());
		
	}
	
	public static void checkDay(Day day) {
		
//		Course c = day;
		
		Day sunday = Day.MON;
		
//		Day otherDay = sunday;
		
		String dayString = sunday.toString();
		
		System.out.println(dayString);
		System.out.println(sunday.ordinal());
		
	}

}
