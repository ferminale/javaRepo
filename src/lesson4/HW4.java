package lesson4;

//2:30:56

import java.util.Random;
import java.util.Scanner;

public class HW4 {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    //Map
    public static char[][] map;
    public static char[][] mapForTraps;
    public static int mapW;
    public static int mapH;
    public static int mapSizeMin = 3;
    public static int mapSizeMax = 6;
    public static char empty = '_';
    public static char ready = '+';
    public static int numberOfRound = 0;


    //Player
    public static char player = '@';
    public static String playerName = "Sergey";
    public static int playerHP = 100;
    public static int playerX;
    public static int playerY;
    public static final int playerMoveUp = 8;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;
    public static final int playerMoveDown = 2;


    //Trap
    public static char trap = 'T';
    public static int trapAttack;
    public static int trapCount;
    public static int trapAttackMin = 5;
    public static int trapAttackMax = 15;

    public static void main(String[] args) {

        while (isPlayerAlive()) {
            ++numberOfRound;
            System.out.println("Prepare for battle! Round: " + numberOfRound);
            currentRound();
        }

        System.out.println("Game Over! Rounds passed: " + numberOfRound);
    }

    public static void currentRound() {

            createMap();
            spawnPlayer();
            spawnTrap();

            while (true) {
                showMap();
                movePlayer();

                if (!isPlayerAlive()) {
                    System.out.println(playerName + " is dead");
                    break;
                }

                if (isFullMap()) {
                    System.out.println(playerName + " win this map!");
                    break;
                }
            }
        }




    public static void createMap () {
        mapW = randomValue(mapSizeMin, mapSizeMax);
        mapH = randomValue(mapSizeMin, mapSizeMax);
        map = new char[mapH][mapW];
        mapForTraps = new char[mapH][mapW];

        for (int y = 0; y < mapH; y++) {
            for (int x = 0; x < mapW; x++) {
                map[y][x] = empty;
                mapForTraps[y][x] = empty;
            }

        }
        System.out.println("Map has been created.");
        System.out.println("mapWight: " + mapW + " mapHeight: " + mapH);
    }

    public static void showMap() {
        System.out.println("_________ MAP _________");
        for (int y = 0; y < mapH; y++) {
            for (int x = 0; x < mapW; x++) {
                System.out.print("|" + map[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void spawnPlayer () {
        playerX = randomValue(0, mapW - 1);
        playerY = randomValue(0, mapH - 1);
        map[playerY][playerX] = player;
        System.out.println(playerName + " has spawn in [" + (playerX + 1) + ":" + (playerY + 1) + "]");

    }


    public static void spawnTrap () {
        trapAttack = randomValue(trapAttackMin, trapAttackMax);
        trapCount = (mapH + mapW) / 2;

        int trapX;
        int trapY;

        for (int i = 1; i <= trapCount; i++) {
           do {
               trapX = random.nextInt(mapW);
               trapY = random.nextInt(mapH);
           } while (!isEmpty(map, trapX, trapY) || !isEmpty(mapForTraps, trapX, trapY));

           mapForTraps[trapY][trapX] = trap;

        }
        System.out.println(trapCount + " trap's has been created. Trap attack = " + trapAttack);
    }

    public static void movePlayer() {
        int currentPlayerX = playerX;
        int currentPlayerY = playerY;
        int playerDestination;
        do {
            System.out.print("Enter ur move: (UP: " + playerMoveUp + " | Down: " + playerMoveDown + " | Left : " + playerMoveLeft + " | Right: " + playerMoveRight + ">>>");

        playerDestination = scanner.nextInt();

        switch (playerDestination) {
            case playerMoveUp:
                playerY -= 1;
                break;
            case playerMoveDown:
                playerY += 1;
                break;
            case playerMoveLeft:
                playerX -= 1;
                break;
            case playerMoveRight:
                playerX += 1;
                break;
        }
    } while (!checkValidMove(currentPlayerX, currentPlayerY, playerX, playerY));
        playerMoveAction(currentPlayerX, currentPlayerY, playerX, playerY);
    }

    public static boolean isEmpty(char[][] thisMap, int x, int y) {
        return thisMap[y][x] == empty;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapH; y++) {
            for (int x = 0; x < mapW; x++) {
                if(map[y][x] == empty) return false;
            }
        }
        return true;
    }


    public static boolean checkValidMove(int pastX, int pastY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < mapW && nextY >= 0 && nextY < mapH) {
            System.out.println(playerName + " move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success");
            return true;
        } else {
            System.out.println(playerName + " move invalid! Please try again.");
            playerX = pastX;
            playerY = pastY;
            return false;
        }
    }

    public static void playerMoveAction(int pastX, int pastY, int nextX, int nextY) {
        if (mapForTraps[nextY][nextX] == trap) {
            playerHP -= trapAttack;
            trapCount--;
            System.out.println("Alarm! " + playerName + " has been attack. HP = " + playerHP);
        }
        map[nextY][nextX] = player;
        map[pastY][pastX] = ready;
    }


    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isPlayerAlive() {
        return playerHP > 0;
    }
}

