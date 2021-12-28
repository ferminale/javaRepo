package GUIApp.windowParts;

import GUIApp.MainWindow;
import GUIApp.model.Player;
import GUIApp.model.Trap;
import GUIApp.tools.Tools;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {

    private MainWindow mainWindow;

    private int[][] map;
    private int[][] invisibleMap;
    private int mapWight;
    private int mapHeight;
    private int mapSizeMin = 3;
    private int mapSizeMax = 6;

    private int cellPlayer = 1;
    private int cellTrap = 2;
    private int cellEmpty = 0;
    private int cellReady = 99;

    private int levelCount;

    private Player player;
    private Trap trap;

    private int cellWidth;
    private int cellHeight;

    private boolean isMapExist;
    private boolean isGameOver;

    public GamePanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setBackground(Color.BLACK);
        isMapExist = false;
    }

    public void launchGame() {
        player = new Player("Boris");
        levelCount = 0;
        levelCycle();
        mainWindow.refreshInfo(this);
        isGameOver = false;
    }

    private void levelCycle() {
        createMap();
        spawnPlayer();
        spawnTrap();
        ++levelCount;
        repaint();
        mainWindow.recordLog("Start Level " + levelCount);
    }

    private void render(Graphics g) {
        if (!isMapExist) {
            return;
        }

        paintGameMap(g);

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {

                if (map[y][x] == cellEmpty) {
                    continue;
                }

                if (map[y][x] == cellPlayer) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }

                if (map[y][x] == cellReady) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

    public void updatePlayer(int key) {
        if (!isMapExist) {
            return;
        }

        if (isGameOver) {
            return;
        }

        int currentPlayerX = player.getX();
        int currentPlayerY = player.getY();

        switch (key) {
            case Player.playerMoveUp:
                player.moveUp();
                break;
            case Player.playerMoveDown:
                player.moveDown();
                break;
            case Player.playerMoveLeft:
                player.moveLeft();
                break;
            case Player.playerMoveRight:
                player.moveRight();
                break;
        }

        if (!checkValidMove(currentPlayerX, currentPlayerY, player.getX(), player.getY())) {
            return;
        }

        playerMoveAction(currentPlayerX, currentPlayerY, player.getX(), player.getY());
        mainWindow.refreshInfo(this);
        repaint();
    }

    private void paintGameMap(Graphics g) {
        int widthSelf = getWidth();
        int heightSelf = getHeight();

        cellWidth = widthSelf / mapWight;
        cellHeight = heightSelf / mapHeight;

        g.setColor(Color.WHITE);

        for (int i = 0; i <= mapHeight ; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, widthSelf, y);
        }

        for (int i = 0; i <= mapWight ; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, heightSelf);
        }
    }

    private void createMap() {
        mapWight = Tools.randomValue(mapSizeMin, mapSizeMax);
        mapHeight = Tools.randomValue(mapSizeMin, mapSizeMax);
        map = new int[mapHeight][mapWight];
        invisibleMap = new int[mapHeight][mapWight];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                map[y][x] = cellEmpty;
                invisibleMap[y][x] = cellEmpty;
            }
        }
        isMapExist = true;
    }

    private void spawnPlayer() {
        player.setPosition(Tools.randomValue(0, mapWight - 1), Tools.randomValue(0, mapHeight - 1));
        map[player.getY()][player.getX()] = cellPlayer;
    }

    private void spawnTrap() {
        trap = new Trap((mapWight + mapHeight) / 2);

        int trapX;
        int trapY;

        for (int i = 1; i <= trap.getCount(); i++) {

            do {
                trapX = Tools.random.nextInt(mapWight);
                trapY = Tools.random.nextInt(mapHeight);
            } while (!isEmpty(map, trapX, trapY) || !isEmpty(invisibleMap, trapX, trapY));

            invisibleMap[trapY][trapX] = cellTrap;
        }
    }

    private boolean isEmpty(int[][] inputMap, int x, int y) {
        return inputMap[y][x] == cellEmpty;
    }

    private boolean checkValidMove(int pastX, int pastY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < mapWight && nextY >= 0 && nextY < mapHeight) {
            return true;
        } else {
            player.setPosition(pastX, pastY);
            mainWindow.recordLog(player.getName() + " get invalid move");
            return false;
        }
    }

    private void playerMoveAction(int pastX, int pastY, int nextX, int nextY) {
        if (invisibleMap[nextY][nextX] == cellTrap) {
            player.decreaseHP(trap.getAttack());
            trap.decreaseTrapCount();
            invisibleMap[nextY][nextX] = cellEmpty;
            mainWindow.recordLog(player.getName() + " get damage is " + trap.getAttack());
        }

        map[nextY][nextX] = cellPlayer;
        map[pastY][pastX] = cellReady;

        if (!player.isAlive()) {
            isGameOver = true;
            JOptionPane.showMessageDialog(this, player.getName() + " is dead. Game Over");
            mainWindow.recordLog(player.getName() + " is dead. Game Over");
        }

        if (!trap.isExistTrap()) {
            player.increaseExp(300);
            levelCycle();
            JOptionPane.showMessageDialog(this, player.getName() + " go to Level " + levelCount);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public int getLevelCount() {
        return levelCount;
    }

    public int getCountTrap(){
        return trap.getCount();
    }

    public String getMapSize() {
        return mapWight + ":" + mapHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
}
