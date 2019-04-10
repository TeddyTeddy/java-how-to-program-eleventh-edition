public class Test2 {
    public static void main(String[] args) {
        /* Create a new Manager object and assign its reference to a variable of Employee type*/
        Employee emp = new Manager();

        /* Call the setSalary() method */
        int salary = 12000;
        ((Manager)emp).setSalary(salary); /* Which setSalary() method is called. Employee.setSalary() or Manager.setSalary()*/
    }
}