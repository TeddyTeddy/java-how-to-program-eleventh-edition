class Shape {
    public double perimeter(double r) {
        return 2*Math.PI*r;
    }

    public int perimeter(int a) {
        return 4*a;
    }

    public int perimeter(int a, int b, int c) {
        return a+b+c;
    }
}
public class Test5 {
    public static void main(String[] args) {
        Shape obj = new Shape();

        obj.perimeter(2.3);

        obj.perimeter(5);

        obj.perimeter(3,4,5);
    }
}
