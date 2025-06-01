package OopsConcepts.Polymorphism;

public class square {
	
	int length=20, height=30, width=15;
	double  len, hei, wid;
	
	square()
	{
		length=height=width;
		
	}
	
	square(int l, int h, int w)
	{
		length=l;
		height=h; 
		width=w;
	}
	
	square(double x, double y, double z)
	{
		len=x;
		hei=y; 
		wid=z;
	}
	
	square(double lenth)
	{
		len=hei=wid=lenth;
	}
	
	double volume()
	
	{
		return(len*hei*wid);
		
	}
	
	int intVol()
	
	{
		return(length*height*width);
		
	}

}
