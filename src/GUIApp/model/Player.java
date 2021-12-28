package GUIApp.model;

public class Player {

    private String name;
    private int hp;
    private int str;
    private int x;
    private int y;
    private int exp;

    public static final int playerMoveUp = 8;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;
    public static final int playerMoveDown = 2;

    public Player(String name) {
        this.name = name;
        hp = 100;
        str = 15;
    }

    public void moveUp() {
        y -= 1;
    }

    public void moveDown() {
        y += 1;
    }

    public void moveLeft() {
        x -= 1;
    }

    public void moveRight() {
        x += 1;
    }

    public void decreaseHP(int value) {
        hp -= value;
    }

    public void increaseExp(int value) {
        exp += value;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getStr() {
        return str;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPosition() {
        return (x + 1) + ":" + (y + 1);
    }

    public int getExp() {
        return exp;
    }
}
