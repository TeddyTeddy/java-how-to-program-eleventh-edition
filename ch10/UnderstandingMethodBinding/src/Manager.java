public class Manager extends Employee {
    // method overloading
    public void setSalary(int salary) {
        System.out.println("Inside Manager.setSalary()");
    }

    public static void greet() {
        System.out.println("Greetings from Manager");
    }
}