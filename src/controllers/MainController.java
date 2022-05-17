package controllers;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import models.MainModel;
import views.MainFrame;

public class MainController {
    MainFrame mainFrame;
    MainModel mainModel;
    enum Irany {
        ESZAK, DEL, KELET, NYUGAT, NO
    }
    public MainController() {
        this.mainFrame = new MainFrame();
        this.mainModel = new MainModel();
        this.setEvents();
    }
    private void setEvents() {
        for(int i=0; i<15; i++) {
            mainFrame.buttons[i].addActionListener(event->onClickButtons(event));
        }
        
    }
    private void onClickButtons(ActionEvent event) {
        
        JButton button = (JButton) event.getSource();

        checkDirection(button);
    }
    private void checkDirection(JButton button) {
        //jobbra?
        int x = button.getLocation().x;
        int y = button.getLocation().y;
        System.out.println(x + " " + y);
        Irany irany = Irany.NO;
        if(x<750 && checkRight(x, y)) {
            irany = Irany.KELET;
        }
        System.out.println(irany);
    }
    private boolean checkRight(int act_x, int act_y) {
        boolean direction_ok = true;
        for(int i=0; i<15; i++) {
            int x = mainFrame.buttons[i].getLocation().x;
            int y = mainFrame.buttons[i].getLocation().y;
            if(act_y == y && act_x + 250 == x) {
                direction_ok = false;
            }
        }
        return direction_ok;
    }
}
