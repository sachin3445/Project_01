package WrapperClass;

// Can access witin a same class
class praccmodifier
{
private int a=20; private int b=30;
	
	 void sum()
	{
		System.out.println(a+b);
	}
}	 
	 public class privateAccessModifier {
	 public static void main(String[] args) 
	 {
		 praccmodifier pr=new praccmodifier();
		 pr.sum();

	 }
	 
}