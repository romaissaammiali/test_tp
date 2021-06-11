package org.emp.gl.gui;



import org.emp.gl.layout.MazeGrid;
import org.emp.gl.timer.service.TimerChangeListener;

import java.beans.PropertyChangeEvent;
import javax.swing.*;

public class Robot extends JPanel implements TimerChangeListener {

    private int x =0;
    private int y =0;
    String goinTo="";
    private final MazeGrid mazeGrid;
    public Robot(MazeGrid mazeGrid){
        this.mazeGrid = mazeGrid;
        x = 1;
        y = 1;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

            switch (goinTo){
                case "left":{
                    moveLeft(mazeGrid); break;
                }
                case "right":{
                    moveRight(mazeGrid);break;
                }
                case "up":{
                    moveUp(mazeGrid);break;
                }
                case "down":{
                    moveDown(mazeGrid);break;
                }

            }
    }


   public void moveLeft(MazeGrid mazeGrid){
        if((mazeGrid.get(x -1, y) != '#') && (mazeGrid.get(x -1, y) != '=')){
            mazeGrid.set(x, y, 'O');
            if(mazeGrid.get(x -=1, y) == '8')	Win();
            else 	mazeGrid.set(x, y, 'X');
        }
        repaint();
    }
    public void moveRight(MazeGrid mazeGrid){
        if((mazeGrid.get(x +1, y) != '#') && (mazeGrid.get(x +1, y) != '=')){
            mazeGrid.set(x, y, 'O');
            if(mazeGrid.get(x +=1, y) == '8')	Win();
            else	mazeGrid.set(x, y, 'X');
        }
    }
    public void moveUp(MazeGrid mazeGrid){
        if((mazeGrid.get(x, y -1) != '#') && (mazeGrid.get(x, y -1) != '=')){
            mazeGrid.set(x, y, 'O');
            if(mazeGrid.get(x, y -=1) == '8')	Win();
            else	mazeGrid.set(x, y, 'X');
        }
    }
    public void moveDown(MazeGrid mazeGrid){
        if((mazeGrid.get(x, y +1) != '#') && (mazeGrid.get(x, y +1) != '=')){
            mazeGrid.set(x, y, 'O');
            if(mazeGrid.get(x, y +=1) == '8') Win();
            else	mazeGrid.set(x, y, 'X');
        }
        repaint();
    }
    public void Win(){
        new PlayControl(20);
    }

    public void setGoinTo(String goinTo) {
        this.goinTo = goinTo;
    }

    public String getGoinTo() {
        return goinTo;
    }
}