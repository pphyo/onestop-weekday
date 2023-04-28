package com.jdc.j17;

public class SealedApp {

	public static void main(String[] args) {
		
		Node singleNode = new SingleNode();
		singleNode.setNode(1);
		System.out.println(singleNode.getNode());
		
		Node triangle = new Triangle();
		triangle.setNode(3);
		System.out.println(triangle.getNode());
		
		Node pairNode = new PairNode();
		pairNode.setNode(2);
		System.out.println(pairNode.getNode());
		
		Node rectangle = new Rectangle();
		rectangle.setNode(4);
		System.out.println(rectangle.getNode());
	

	}

}
