package cn.cdutetc.example6;
public class OuterF {
    private void internalMethod(boolean b){
        if(b){
            class Localclass{
                private String id;
                Localclass(String s) {
                    id = s;
                }
                String getName(){
                    return id;
                }
            }
            Localclass ts = new Localclass("¹ó±ö");
            System.out.println(ts.getName());
        }
    }
    
    public void isLocal(){
        internalMethod(true);
    }
    
    public static void main(String[] args) {
        OuterF out = new OuterF();
        out.isLocal();
    }
}