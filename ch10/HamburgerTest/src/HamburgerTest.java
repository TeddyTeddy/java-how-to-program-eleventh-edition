public class HamburgerTest {
    public static void main(String[] args) {
        Hamburger hamburger =  new Hamburger("Basic Hamburger", RollType.WHITE_BREAD, Meat.SAUSAGE, 6.78);
        System.out.println("Basic hamburger with no additions");
        System.out.printf("%s%n%s%.2f%n%n", hamburger, "Total price: ", hamburger.getTotalPrice());
        System.out.println("Adding hamburger new additions");
        try {
            hamburger.setAddition(Addition.TOMATO);
            hamburger.setAddition(Addition.CARROT);
            hamburger.setAddition(Addition.EGG);
            hamburger.setAddition(Addition.LETTUCE);
            System.out.printf("%s%n%s%.2f%n%n", hamburger, "Total price: ", hamburger.getTotalPrice());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        HealthyBurger healthyBurger =  new HealthyBurger( Meat.CHICKEN, 7.75);
        System.out.println("Healthy Burger with no additions");
        System.out.printf("%s%n%s%.2f%n%n", healthyBurger, "Total price: ", healthyBurger.getTotalPrice() );
        System.out.println("Adding healthyBurger new additions");
        try {
            healthyBurger.setAddition(Addition.TOMATO);
            healthyBurger.setAddition(Addition.CARROT);
            healthyBurger.setAddition(Addition.EGG);
            healthyBurger.setAddition(Addition.LETTUCE);
            healthyBurger.setHealthyAddition(Addition.PICKLES);
            healthyBurger.setHealthyAddition(Addition.UNION);
            System.out.printf("%s%n%s%.2f%n%n", healthyBurger, "Total price: ", healthyBurger.getTotalPrice());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            DeluxeHamburger deluxe =  new DeluxeHamburger( RollType.DARK_BREAD, Meat.BEEF, 9.99);
            System.out.printf("%s%n%s%.2f%n%n", deluxe, "Total price: ", deluxe.getTotalPrice() );
            System.out.println("Deluxe Burger cannot have additions. Attempting to set one addition");
            deluxe.setAddition(Addition.TOMATO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
