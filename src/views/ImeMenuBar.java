package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImeMenuBar extends JMenuBar {

    JMenu fileMenu;
    JMenu toolsMenu;
    public JMenuItem exitItem;
    public JMenuItem mixItem;

    public ImeMenuBar() {
        this.fileMenu = new JMenu("Fájl");
        this.toolsMenu = new JMenu("Eszközök");
        this.exitItem = new JMenuItem("Kilépés");
        this.mixItem = new JMenuItem("Keverés");

        this.fileMenu.add(this.exitItem);
        this.toolsMenu.add(this.mixItem);

        this.add(this.fileMenu);
        this.add(this.toolsMenu);
    }
    
}
