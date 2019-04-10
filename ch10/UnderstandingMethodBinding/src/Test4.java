// https://stackoverflow.com/questions/29381292/method-binding-in-java
public class Test4 {
    public static void main(String[] args) {
        BindingTest_Sub sub1 = new BindingTest_Sub();
        BindingTest_Base sub2 = new BindingTest_Sub();

        sub1.ovrLd(new Integer(1));       //  statement 1
        sub2.ovrLd(new Integer(2));       //  statement 2
        sub2.ovrRd();                           //  statement 3
    }
}

class BindingTest_Base {
    void ovrLd(Object obj){
        System.out.println("BindingTest_Base ovrLd()");
    }
    void ovrRd(){
        System.out.println("BindingTest_Base ovrRd()");
    }
}

class BindingTest_Sub extends BindingTest_Base{
    void ovrLd(Integer i){
        System.out.println("BindingTest_Sub ovrLd()");
    }
    void ovrRd(){
        System.out.println("BindingTest_Sub ovrRd()");
    }
}