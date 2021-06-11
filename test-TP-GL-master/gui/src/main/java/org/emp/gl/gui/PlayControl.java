package org.emp.gl.gui;
import org.emp.gl.layout.MazeGrid;
import org.emp.gl.lookup.Lookup;
import org.emp.gl.timer.service.TimerService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PlayControl {

    static JFrame frame = new JFrame("Labyrinthe");
    JPanel p = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new BorderLayout());
    String state = "";
    public PlayControl(int level){

        final MazeGrid test = Lookup.getInstance().getService(MazeGrid.class);
        final Robot robot = Lookup.getInstance().getService(Robot.class);
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        p.add(test, BorderLayout.CENTER);
        p.setFocusable(true);
        frame.add(p, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.SOUTH);


        JButton south = new JButton("South");
        south.setFocusable(false);
        p2.add(south, BorderLayout.SOUTH);
        south.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                robot.setGoinTo("down");
            }
        });

        JButton north = new JButton("North");
        north.setFocusable(false);
        p2.add(north, BorderLayout.NORTH);
        north.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                robot.setGoinTo("up");
            }
        });

        JButton east = new JButton("East");
        east.setFocusable(false);
        p2.add(east, BorderLayout.EAST);
        east.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                robot.setGoinTo("right");
            }
        });


        JButton west = new JButton("West");
        west.setFocusable(false);
        p2.add(west, BorderLayout.WEST);
        west.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                robot.setGoinTo("left");
            }
        });

        JButton menu = new JButton("New Game");
        menu.setFocusable(false);
        p2.add(menu, BorderLayout.CENTER);
        menu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                frame.dispose();
                new MainMenu();
            }
        });

        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.green);
        frame.setVisible(true);
    }
    public PlayControl(int level, int money){
        frame.dispose();
        JFrame frame2 = new JFrame();
        frame2.setBackground(Color.green);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500,500);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }

}