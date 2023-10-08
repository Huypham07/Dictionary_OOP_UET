package GUI;

import Dict.*;
import javax.swing.*;
import java.awt.*;

public class DictionaryUI {
    private Dictionary dictionary;
    private JFrame frame;
    private JPanel Panel;
    private PanelRound searchBarPanel;
    private JPanel TopPanel;
    private JButton translateButton;
    private JButton addWordButton;
    private JButton learnButton;
    private JButton importButton;
    private JButton exportButton;
    private JLabel Logo;
    private JLabel headerApp;
    private JLabel iconSearchBar;
    private JTextField searchBar;
    private JButton editButton;
    private JPanel TranslatePanel;


    public DictionaryUI() {
        createUIComponents();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //search bar
        searchBarPanel = new PanelRound();
        searchBarPanel.setRoundTopLeft(400);
        searchBarPanel.setRoundBottomLeft(400);
        searchBarPanel.setRoundTopRight(400);
        searchBarPanel.setRoundBottomRight(400);
//        searchBarPanel.setLayout(GridLayout);
        searchBarPanel.setSize(400, 150);
        searchBarPanel.setBackground(Color.CYAN);

        Panel = new JPanel();
        Logo = new JLabel(new ImageIcon("src/main/java/data/monster.png"), JLabel.CENTER);
        iconSearchBar = new JLabel(new ImageIcon("src/main/java/data/monster.png"));
        searchBarPanel.add(Logo);

        frame = new JFrame("Dictionary");
        ImageIcon iconApp = new ImageIcon("src/main/java/data/monster.png");
        frame.setIconImage(iconApp.getImage());
//        frame.setContentPane(Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

//        frame.add(Logo);
        frame.add(searchBarPanel);
    }

    public static void main(String[] args) {
        new DictionaryUI();
    }
}
