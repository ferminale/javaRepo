package GUIApp.windowParts.infoPanelParts;

import GUIApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControlArea extends JPanel {

    private JButton startGame;
    private JButton exitGame;

    private InfoPanel infoPanel;

    private int STATUS_OK = 0;

    public GameControlArea(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
        setLayout(new GridLayout(3, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        startGame = new JButton("START GAME");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.launchGame();
            }
        });

        exitGame = new JButton("EXIT GAME");
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(STATUS_OK);
            }
        });

        add(new JLabel("=Game Controls=", SwingConstants.CENTER));
        add(startGame);
        add(exitGame);
    }
}
