package lesson6;

public abstract class Animal {

    protected String name;
    private int maxRun;
    private int maxSwim;

    Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
    }



    String getName() {
        return this.name;
    }

    int getMaxRun() {
        return this.maxRun;
    }

    int getMaxSwim() {
        return this.maxSwim;
    }

    protected void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м., потому что выдохся");
        }

    }

    protected void swim(int distance) {
        if (distance <= maxSwim) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м., потому что утонул");
        }
    }
}


