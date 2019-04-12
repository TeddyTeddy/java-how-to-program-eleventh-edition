class Animal {
    public void makeNoise() {
        System.out.println("Noise unknown");
    }
}

class Cat extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("Miyaw");
    }
}

class Dog extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("Wof");
    }
}

public class Test6 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeNoise();
        cat.makeNoise();
    }
}