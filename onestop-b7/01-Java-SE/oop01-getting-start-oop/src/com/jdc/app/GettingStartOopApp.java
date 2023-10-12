package com.jdc.app;

public class GettingStartOopApp {
	
	public static void main(String[] args) {
		
		var u1 = new User("Kagura", 20, "000111");
		var u2 = new User("Kagura", 20, "100100");
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u1.equals(u2));
		
		String format = """
				ID    : %d
				Name  : %s
				Age   : %d
				Phone : %s
				""";

		
		var nami = new User();
		nami.setName("Nami");
		nami.setAge(26);
		nami.setPhone("091230303");
		User.id ++;
		nami.ageUp();
		nami.ageUp();
				
		var zoro = new User();
		zoro.setName("Zoro");
		zoro.setAge(23);
		zoro.setPhone("3829394903");
		User.id ++;
		zoro.ageUp();
				
		System.out.println(
				format.formatted(
						User.id, nami.getName(), 
						nami.getAge(), nami.getPhone()
						));
						
		System.out.println(
				format.formatted(
						User.id, zoro.getName(),
						zoro.getAge(), zoro.getPhone()
						));
		
		var luffy = new User("Monkey D Luffy", 22, "093202922");
		User.id ++;

		System.out.println(
				format.formatted(
						User.id, luffy.getName(),
						luffy.getAge(), luffy.getPhone()
						));
	}

}




