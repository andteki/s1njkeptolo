package views;

import java.awt.Image;
import java.awt.Point;

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
    public final int IMAGE_WIDTH=100;
    public final int IMAGE_HEIGHT=100;

    Point[] basePosition = {
        new Point(0, 0),
        new Point(IMAGE_WIDTH, 0),
        new Point(IMAGE_WIDTH*2, 0),
        new Point(IMAGE_WIDTH*3, 0),
        new Point(0, IMAGE_HEIGHT),
        new Point(IMAGE_WIDTH, IMAGE_HEIGHT),
        new Point(IMAGE_WIDTH*2, IMAGE_HEIGHT),
        new Point(IMAGE_WIDTH*3, IMAGE_HEIGHT),
        new Point(0, IMAGE_HEIGHT*2),
        new Point(IMAGE_WIDTH, IMAGE_HEIGHT*2),
        new Point(IMAGE_WIDTH*2, IMAGE_HEIGHT*2),
        new Point(IMAGE_WIDTH*3, IMAGE_HEIGHT*2),
        new Point(0, IMAGE_HEIGHT*3),
        new Point(IMAGE_WIDTH, IMAGE_HEIGHT*3),
        new Point(IMAGE_WIDTH*2, IMAGE_HEIGHT*3)
    };    

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
            ImageIcon imageIcon = resizeImageIcon(imageIcons[i], IMAGE_WIDTH, IMAGE_HEIGHT);
            buttons[i] = new JButton(imageIcon);
            buttons[i].setLocation(basePosition[i]);
            buttons[i].setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
        }
    }
    private void setMainPanel() {
        this.mainPanel = new JPanel();
        this.mainPanel.setBounds(10, 10, IMAGE_WIDTH*4+20, IMAGE_HEIGHT*4+50);
        this.mainPanel.setLayout(null);
        for(int i=0;i<15; i++) {
            this.mainPanel.add(this.buttons[i]);
        }
    }
    private void setMainFrame() {
        this.setJMenuBar(new ImeMenuBar());
        this.add(this.mainPanel);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(IMAGE_WIDTH*4+24, IMAGE_HEIGHT*4+70);
        this.setVisible(true);
    }
    private ImageIcon resizeImageIcon(ImageIcon origImageIcon, int width, int height) {
        Image image = origImageIcon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(newImage);
        return imageIcon;
    }
}
