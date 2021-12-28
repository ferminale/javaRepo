package lesson6;

public class HW6 {
    public static void main(String[] args) {
        Cat cat = new Cat("Коржик", 200, 10);
        Cat cat1 = new Cat("Булочка", 200, 20);
        Dog dog = new Dog("Бим", 500, 10);
        Dog dog1 = new Dog("Бом", 500, 10);

      Animal[] zoo = {cat, cat1, dog, dog1};

        for (int i = 0; i < zoo.length; i++) {

            zoo[i].run(250);
            zoo[i].swim(8);

        }
    }
}
