package controllers;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import models.MainModel;
import views.MainFrame;

public class MainController {
    MainFrame mainFrame;
    MainModel mainModel;
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
        int x = button.getLocation().x;
        int y = button.getLocation().y;
        System.out.println(x + " " + y);

    }
}
