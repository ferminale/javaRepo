package GUIApp.model;

import GUIApp.tools.Tools;

public class Trap {

    private int x;
    private int y;
    private int attack;
    private int count;

    private int valueMin = 5;
    private int valueMax = 15;

    public Trap(int count) {
        this.attack = Tools.randomValue(valueMin, valueMax);
        this.count = count;
    }

    public void decreaseTrapCount() {
        --count;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public boolean isExistTrap() {
        return count > 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
