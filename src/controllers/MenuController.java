package controllers;

import views.ImeMenuBar;
import views.MainFrame;

public class MenuController {
    MainFrame mainFrame;
    ImeMenuBar bar;
    public MenuController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        bar = (ImeMenuBar) this.mainFrame.getJMenuBar();
        bar.exitItem.addActionListener(e -> onClickExitItem());
        bar.mixItem.addActionListener(e -> onClickMixItem());
    }
    private void onClickExitItem() {
        System.exit(0);
    }
    private void onClickMixItem() {
        System.out.println("Keverés árnyékeljárás");
    }
}
