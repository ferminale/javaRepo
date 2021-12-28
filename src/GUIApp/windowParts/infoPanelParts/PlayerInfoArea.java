package GUIApp.windowParts.infoPanelParts;

import GUIApp.model.Player;

import javax.swing.*;
import java.awt.*;


public class PlayerInfoArea extends JPanel {

    private String prefixHP = "Health: ";
    private String prefixStr = "Str: ";
    private String prefixPosition = "Position: ";

    private JLabel playerHP;
    private JLabel playerStr;
    private JLabel playerPosition;

    public PlayerInfoArea() {
        setLayout(new GridLayout(4,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        playerHP = new JLabel(prefixHP + "-");
        playerStr = new JLabel(prefixStr + "-");
        playerPosition = new JLabel(prefixPosition + "-:-");

        add(new JLabel("= Player Info =", SwingConstants.CENTER));
        add(playerHP);
        add(playerStr);
        add(playerPosition);
    }

    public void refresh(Player player) {
        playerHP.setText(prefixHP + player.getHp());
        playerStr.setText(prefixStr + player.getStr());
        playerPosition.setText(prefixPosition + player.getPosition());
    }

}
