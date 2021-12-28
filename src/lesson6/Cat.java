package lesson6;

public class Cat extends Animal {

    public Cat(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
    }
    @Override
    protected void swim(int distance) {
        System.out.println(name + "не смог проплыть " + distance + " м., потому что это кот и ему этого не надо.");
}
}
