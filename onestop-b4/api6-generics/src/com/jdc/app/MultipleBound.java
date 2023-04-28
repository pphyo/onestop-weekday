package com.jdc.app;

public class MultipleBound {

	public static void main(String[] args) {
		
		GenericeMultiBound<AllChild> app = new GenericeMultiBound<>();

	}

}

class GenericeMultiBound<T extends B & A & C> {
	
}

interface A {}
interface B {}
interface C {}

class AChild implements A {}
class BChild implements B {}
class CChild implements C {}

class AllChild implements B, C, A {}



