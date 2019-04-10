public class Test3 {
    public static void main(String[] args) {
        /* Create a new Manager object and assign its reference to a variable of Employee type*/
        Employee emp = new Manager();

        ((Manager) emp).greet();
    }
}