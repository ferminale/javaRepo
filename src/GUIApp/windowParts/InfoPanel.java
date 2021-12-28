package GUIApp.windowParts;

import GUIApp.MainWindow;
import GUIApp.windowParts.infoPanelParts.GameControlArea;
import GUIApp.windowParts.infoPanelParts.GameInfoArea;
import GUIApp.windowParts.infoPanelParts.PlayerControlArea;
import GUIApp.windowParts.infoPanelParts.PlayerInfoArea;

import javax.naming.spi.DirectoryManager;
import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private int panelWidth = 200;

    private GameControlArea gameControlArea;
    private GameInfoArea gameInfoArea;
    private PlayerInfoArea playerInfoArea;
    private PlayerControlArea playerControlArea;

    private JTextArea log;
    private JScrollPane scroll;

    private MainWindow mainWindow;

    public InfoPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        preparePanel();
        createParts();
        prepareLogs();

        add(gameControlArea);
        add(gameInfoArea);
        add(playerInfoArea);
        add(playerControlArea);
        add(scroll);
    }

    private void preparePanel() {
        setPreferredSize(new Dimension(panelWidth, mainWindow.getHeight()));
        setLayout(new GridLayout(5, 1));
    }

    private void createParts() {
        gameControlArea = new GameControlArea(this);
        gameInfoArea = new GameInfoArea();
        playerInfoArea = new PlayerInfoArea();
        playerControlArea = new PlayerControlArea(this);
    }

    private void prepareLogs() {
        log = new JTextArea();
        log.setEditable(false);
        log.setLineWrap(true);
        scroll = new JScrollPane(log);
    }

    public void recordLog(String msg) {
        log.append(msg + "\n");
    }

    public void launchGame() {
        mainWindow.launchGame();
    }

    public void refreshInfo(GamePanel map) {
        gameInfoArea.refresh(map.getMapSize(), map.getLevelCount(), map.getCountTrap());
        playerInfoArea.refresh(map.getPlayer());
    }

    public void updatePlayer(int key) {
        mainWindow.updatePlayer(key);
    }
}
