package cn.cdutetc.example6;

public class OuterE {
	
	private class InnerE1 extends ClassA{
		public void printname()
		{
			super.printname();
		}
	}
	private class InnerE2 extends ClassB
	{
		public void printage()
		{
			super.printage();
		}
	}
    public void printname()
    {
    	new InnerE1().printname();
    }
    public void printage()
    {
    	new InnerE2().printage();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         OuterE out=new OuterE();
         out.printname();
         out.printage();
	}
}
