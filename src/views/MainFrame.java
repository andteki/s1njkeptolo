package views;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    JPanel mainPanel;
    public JButton[] buttons;
    ImageIcon[] imageIcons;
    String[] imageNames = {
        "kep01.png",
        "kep02.png",
        "kep03.png",
        "kep04.png",
        "kep05.png",
        "kep06.png",
        "kep07.png",
        "kep08.png",
        "kep09.png",
        "kep10.png",
        "kep11.png",
        "kep12.png",
        "kep13.png",
        "kep14.png",
        "kep15.png",
    };
    final int IMAGE_WIDTH=250;
    final int IMAGE_HEIGHT=250;
    public MainFrame() {
        this.setMainComponent();
        this.setMainPanel();
        this.setMainFrame();
    }
    private void setMainComponent() {
        imageIcons = new ImageIcon[15];
        for(int i=0;i<15; i++) {
            imageIcons[i] = new ImageIcon("images/" + imageNames[i]);
        }        

        buttons = new JButton[15];
        for(int i=0;i<15; i++) {
            buttons[i] = new JButton(imageIcons[i]);
        }
        setBasePos();
    }
    private void setBasePos() {
        buttons[0].setBounds(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[1].setBounds(250, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[2].setBounds(500, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[3].setBounds(750, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[4].setBounds(0, 250, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[5].setBounds(250, 250, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[6].setBounds(500, 250, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[7].setBounds(750, 250, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[8].setBounds(0, 500, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[9].setBounds(250, 500, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[10].setBounds(500, 500, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[11].setBounds(750, 500, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[12].setBounds(0, 750, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[13].setBounds(250, 750, IMAGE_WIDTH, IMAGE_HEIGHT);
        buttons[14].setBounds(500, 750, IMAGE_WIDTH, IMAGE_HEIGHT);
    }
    private void setMainPanel() {
        this.mainPanel = new JPanel();
        this.mainPanel.setBounds(10, 10, 1020, 1020);
        this.mainPanel.setLayout(null);
        for(int i=0;i<15; i++) {
            this.mainPanel.add(this.buttons[i]);
        }
    }
    private void setMainFrame() {
        this.add(this.mainPanel);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1020, 1050);
        this.setVisible(true);
    }
}
