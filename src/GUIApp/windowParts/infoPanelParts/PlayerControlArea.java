package GUIApp.windowParts.infoPanelParts;

import GUIApp.model.Player;
import GUIApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayerControlArea extends JPanel {

    private JButton btnMoveUp;
    private JButton btnMoveLeft;
    private JButton btnMoveRight;
    private JButton btnMoveDown;

    private InfoPanel infoPanel;

    public PlayerControlArea(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
        setLayout(new GridLayout(2,3));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnMoveUp = new JButton("↑");
        btnMoveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.updatePlayer(Player.playerMoveUp);
            }
        });

        btnMoveLeft = new JButton("←");
        btnMoveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.updatePlayer(Player.playerMoveLeft);
            }
        });

        btnMoveRight = new JButton("→");
        btnMoveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.updatePlayer(Player.playerMoveRight);
            }
        });

        btnMoveDown = new JButton("↓");
        btnMoveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.updatePlayer(Player.playerMoveDown);
            }
        });

        add(new JPanel());
        add(btnMoveUp);
        add(new JPanel());
        add(btnMoveLeft);
        add(btnMoveDown);
        add(btnMoveRight);
    }

}
