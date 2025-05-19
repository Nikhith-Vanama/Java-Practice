class Box
{
	int l,b,h;
	Box()
	{
		l=b=h=-1;
	}
	Box(int l)
	{
		this.l=b=h=l;
	}
	Box(int l,int b,int h)
	{
		this.l=l;
		this.b=b;
		this.h=h;
	}
	int volume()
	{
		return l*b*h;
	}
}
class Volume
{
	public static void main(String[] args)
	{
		Box b1=new Box();
		System.out.println("Default box is "+b1.volume());
		Box b2=new Box(10);
		System.out.println("one box is "+b2.volume());
		Box b3=new Box(10,12,15);
		System.out.println("three box is "+b3.volume());
	}
}