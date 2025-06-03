package mtheodOverRiding;

class bank {
	
	double roi ()
	{
		return 0;
	}
}

class ICICI extends bank{
	double roi()
	{
		return 12.50;
	}
}

class SBI extends bank{
	double roi()
	{
		return 10.50;
	}
}

public class Overridingexample {

	public static void main(String[] args) {



	}

}
