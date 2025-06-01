package OopsConcepts.Polymorphism;

public class mainValumeClass {

	public static void main(String[] args) {
		
		square vol=new square();
		square vol1=new square(20.23, 10.23, 14.15);
		square vol3=new square(24.15);
		square vol4=new square(5, 3, 8);
		System.out.println(vol.intVol());
		System.out.println(vol1.volume());
		System.out.println(vol3.volume());
		System.out.println(vol4.intVol());

	}

}
