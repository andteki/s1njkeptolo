package controllers;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import models.MainModel;
import views.MainFrame;

public class MainController {
    MainFrame mainFrame;
    MainModel mainModel;
    enum Action {
        UP, DOWN, LEFT, RIGHT, NO
    }
    JButton[] buttons;
    int IMAGE_WIDTH;
    int IMAGE_HEIGHT;
    public MainController() {
        this.mainFrame = new MainFrame();
        this.mainModel = new MainModel();        
        this.buttons = this.mainFrame.buttons;
        this.IMAGE_WIDTH = this.mainFrame.IMAGE_WIDTH;
        this.IMAGE_HEIGHT = this.mainFrame.IMAGE_HEIGHT;
        this.setEvents();
    }
    private void setEvents() {
        for(int i=0; i<15; i++) {
            buttons[i].addActionListener(event->onClickButtons(event));
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
        Action action = Action.NO;
        if(x< IMAGE_WIDTH*3 && checkRight(x, y)) {
            action = Action.RIGHT;
        }
        if(x > 0 && checkLeft(x, y)) {
            action = Action.LEFT;
        }
        if(y< IMAGE_HEIGHT*3 && checkDown(x, y)) {
            action = Action.DOWN;
        }
        if(y > 0 && checkUp(x, y)) {
            action = Action.UP;
        }

        System.out.println(action);

        moveImage(action, button);
    }
    private boolean checkRight(int act_x, int act_y) {
        boolean direction_ok = true;
        for(int i=0; i<15; i++) {
            int x = buttons[i].getLocation().x;
            int y = buttons[i].getLocation().y;
            if(act_y == y && act_x + IMAGE_WIDTH == x) {
                direction_ok = false;
            }
        }
        return direction_ok;
    }
    private boolean checkLeft(int act_x, int act_y) {
        boolean direction_ok = true;
        for(int i=0; i<15; i++) {
            int x = buttons[i].getLocation().x;
            int y = buttons[i].getLocation().y;
            if(act_y == y && act_x - IMAGE_WIDTH == x) {
                direction_ok = false;
            }
        }
        return direction_ok;
    }
    private boolean checkDown(int act_x, int act_y) {
        boolean direction_ok = true;
        for(int i=0; i<15; i++) {
            int x = buttons[i].getLocation().x;
            int y = buttons[i].getLocation().y;
            if(act_x == x && act_y + IMAGE_HEIGHT == y) {
                direction_ok = false;
            }
        }
        return direction_ok;
    }
    private boolean checkUp(int act_x, int act_y) {
        boolean direction_ok = true;
        for(int i=0; i<15; i++) {
            int x = buttons[i].getLocation().x;
            int y = buttons[i].getLocation().y;
            if(act_x == x && act_y - IMAGE_WIDTH == y) {
                direction_ok = false;
            }
        }
        return direction_ok;
    }
    private void moveImage(Action action, JButton button) {
        int x = button.getLocation().x;
        int y = button.getLocation().y;
        if(action == Action.RIGHT) {
            button.setLocation(x+IMAGE_WIDTH, y);
        }
        if(action == Action.LEFT) {
            button.setLocation(x-IMAGE_WIDTH, y);
        }
        if(action == Action.DOWN) {
            button.setLocation(x, y+IMAGE_HEIGHT);
        }
        if(action == Action.UP) {
            button.setLocation(x, y-IMAGE_HEIGHT);
        }
    }
}
