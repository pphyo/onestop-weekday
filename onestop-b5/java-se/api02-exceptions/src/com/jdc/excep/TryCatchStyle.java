package com.jdc.excep;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// try with resource
// try finally
// try catch
// try catch finally

// single catch (only catch block and only one exception type in catch block)
// multi catch (multiple exception type in single catch block)
// multiple handler (multiple catch block)

public class TryCatchStyle {

	public static void main(String[] args) {
		
		checkNumber(0);

	}
	
	static void checkNumber(int number) {
		
		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Start Try Block");
			
			Thread.sleep(1000);
			
			File file = new File("");
			file.createNewFile();
			
			for(int i = 0; i < 10; i++) {
				if(i == number)
					System.out.println(i / 0);
				else
					System.out.println(new int[] {1, 1, 1}[5]);
			}
			
			System.out.println("Ending Try Block");
			
		} catch(InterruptedException | IOException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
			throw new AppException("Hi there, it needs to be warned.");
		}
		
//		catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("ArrayIndexOutOfBoundsException Occured");
//		} catch (InterruptedException e) {
//			System.out.println("Interrupted Exception Occured");
//		} catch (RuntimeException e) {
//			System.out.println("Runtime Exception Occured");
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		} 
//		finally {
//			
//			int result = 0;
//			
//			for(int i = 0; i <= number; i++)
//				result += i;
//			
//			System.out.println("Result: " + result);
//			
//		}
		
		System.out.println("Program Terminate...");
		
	}

}
