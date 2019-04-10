import java.util.Arrays;

enum Addition {

    LETTUCE("Lettuce", 2.50),
    TOMATO("Tomato", 1.55),
    CARROT("Carrot", 3.45),
    PICKLES("Pickles", 0.8),
    UNION("Union", 0.5),
    EGG("Egg", 1.15),
    CHIPS("Chips", 2.50),
    DRINKS("Drinks", 3.0);

    // instance variables
    private final String name;
    private final double price;

    Addition(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}

enum RollType {
    WHITE_BREAD,
    DARK_BREAD
};

enum Meat {
    CHICKEN,
    BEACON,
    SAUSAGE,
    BEEF
}

class Hamburger {
    // instance variables
    private String name;
    private Meat meat;
    private RollType rollType;
    private double basePrice;

    private static final int MAX_NUMBER_OF_ADDITIONS = 4;
    private Addition[] additions;

    public Hamburger(String name, RollType rollType, Meat meat, double basePrice) {
        this.name = name;
        this.rollType = rollType;
        this.meat = meat;
        this.basePrice = basePrice;
        this.additions = new Addition[MAX_NUMBER_OF_ADDITIONS]; // an array of nulls created
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "name='" + getName() + '\'' +
                ", meat=" + getMeat() +
                ", rollType=" + getRollType() +
                ", basePrice=" + getBasePrice() +
                ", additions=" + Arrays.toString(getAdditions()) +
                '}';
    }

    public String getName() {
        return name;
    }

    public Meat getMeat() {
        return meat;
    }

    public RollType getRollType() {
        return rollType;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public void setRollType(RollType rollType) {
        this.rollType = rollType;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Addition[] getAdditions() {
        return additions;
    }

    public void setAddition(Addition addition) throws Exception {
        // throw an exception if additions array is full
        boolean isFull = true;
        int i = 0;
        for(; i < additions.length ; ++i) {
            if(additions[i] == null) {
                isFull = false;
                break;
            }
        }
        if(isFull) {
            throw new Exception("Hamburger.setAddition() : Exception : Only " + MAX_NUMBER_OF_ADDITIONS + " additions are allowed!");
        }

        // additions array is not full, can set the addition
        additions[i] = addition;
    }

    public double getTotalPrice() {
        double totalPrice = getBasePrice();
        for(Addition a : additions) {
            if(a != null) {
                totalPrice += a.getPrice();
            }
        }
        return totalPrice;
    }
}

class HealthyBurger extends Hamburger {
    // instance variables
    private static int NUM_OF_HEALTHY_ADDITIONS = 2;
    private Addition[] healthyAdditions;


    public HealthyBurger(Meat meat, double basePrice) {
        super("Healthy Burger", RollType.DARK_BREAD, meat, basePrice);
        this.healthyAdditions = new Addition[NUM_OF_HEALTHY_ADDITIONS]; // creates an array of nulls
    }

    public void setHealthyAddition(Addition a) throws Exception {
        // throw an exception if additions array is full
        boolean isFull = true;
        int i = 0;
        for(; i < healthyAdditions.length ; ++i) {
            if(healthyAdditions[i] == null) {
                isFull = false;
                break;
            }
        }
        if(isFull) {
            throw new Exception("HealthyBurger.setHealthyAddition() : Exception : Only " + NUM_OF_HEALTHY_ADDITIONS + " additions are allowed!");
        }

        // healthyAdditions array is not full, can set the addition
        healthyAdditions[i] = a;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = super.getTotalPrice(); // get Hamburgers total price first for the super Hamburger
        for(Addition a : healthyAdditions) {
            if(a != null) {
                totalPrice += a.getPrice();
            }
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "HealthyBurger{" + "name= " + getName() + '\'' +
                ", meat= " + getMeat() +
                ", rollType= " + getRollType() +
                ", basePrice= " + getBasePrice() +
                ", additions= " + Arrays.toString(getAdditions()) +
                ", healthyAdditions= " + Arrays.toString(healthyAdditions) +
                '}';
    }
}


class DeluxeHamburger extends Hamburger {
    // instance variables none

    public DeluxeHamburger(RollType rollType, Meat meat, double basePrice) throws Exception {
        super("Deluxe Hamburger", rollType, meat, basePrice);
        super.setAddition(Addition.CHIPS);
        super.setAddition(Addition.DRINKS);
    }

    @Override
    public void setAddition(Addition addition) throws Exception {
        throw new Exception("DeluxeHamburger.setAddition() : Exception : Cannot set new additions to Deluxe Hamburger Meal");
    }

    @Override
    public String toString() {
        return "DeluxeHamburger{" +
                "name='" + getName() + '\'' +
                ", meat=" + getMeat() +
                ", rollType=" + getRollType() +
                ", basePrice=" + getBasePrice() +
                ", additions=" + Arrays.toString(getAdditions()) +
                '}';
    }
}