package com.jdc.app;

public class BeforeGeneric {
	
	public static void main(String[] args) {
		
//		Reload strReload = new Reload("Reload");
//		Reload intReload = new Reload(10);
//		
//		int obj = (Integer)strReload.getData(); // ClassCastException
		
//		Container<String> cont1 = new Container<>("Hello Generic");
//		Container<Double> cont2 = new Container<>(100.0);
		
//		Container cont = new Container();
		
		Container<Animal> aniCont = new ChildContainer<>();
		aniCont.setData(new Feline());
		
		Container<Integer> intCont = new IntContainer<String>(" Element");
		intCont.setData(100);
		System.out.println(intCont);
		
		Container<Number> numCont = new Container<>();
		numCont.setData(100);
		numCont.setData(100L);
		numCont.setData(1000.0D);
		numCont.setData(1000.0F);
		
		Pair<String, String> p1 = new OrderPair<>("Alice", "Tank");
		Pair<String, String> p2 = new OrderPair<>("Alice", "Marksman");

		System.out.printf("%s%n%s%n", p1, p2);
		
		System.out.println(Util.compareKey(p1, p2));
	}
	
	

}









