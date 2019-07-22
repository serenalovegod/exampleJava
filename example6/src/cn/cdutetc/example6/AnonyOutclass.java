package cn.cdutetc.example6;
public class AnonyOutclass {
    public InterfaceB getInnerClass(int num,String str2){  
        return new InterfaceB(){
            int number = num + 3;
            public String getString(){
                return str2+number+"岁";
            }
        };        /* 注意：分号不能省 */
    }
    
    public static void main(String[] args) {
        AnonyOutclass out = new AnonyOutclass();
        InterfaceB inner = out.getInnerClass(3, "贵宾");
        System.out.println(inner.getString());
    }
}

interface InterfaceB {
    String getString();
}