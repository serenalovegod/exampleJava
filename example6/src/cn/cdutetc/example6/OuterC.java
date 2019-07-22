package cn.cdutetc.example6;
public class OuterC {
    private class InnerC implements InterfaceA{
	  public void print() {
	    System.out.println("这是一个测试");
    }
}
	    public InterfaceA getIn() {
	      return (InterfaceA) new InnerC();
	    }
}