package ExceptionHandling;

import java.util.Scanner;

public class uncheckedExceptions {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the valid number: ");
			try 
			{
				int num =sc.nextInt();
				int result=num/0;
				System.out.println(num);
				System.out.println(result);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		String s=null;
		try 
		{
			System.out.println(s.length());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
