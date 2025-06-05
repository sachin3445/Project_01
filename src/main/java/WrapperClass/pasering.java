package WrapperClass;

public class pasering {



	public static void main(String[] args) {
		//convert String to permeative data types 
		
		String a="1453", b="true", c="1456.20";
		
		System.out.println(Integer.parseInt(a));
		System.out.println(Boolean.parseBoolean(b));
		System.out.println(Double.parseDouble(c));
		
		//convert permeative data types to string
		int x=48631;
		double y=3445.02;
		char z='p';
		String s= String.valueOf(x);
		String t= String.valueOf(y);
		String u=String.valueOf(z);
		
		System.out.println(s);
		System.out.println(t);
		System.out.println(u);
		

	}

}
