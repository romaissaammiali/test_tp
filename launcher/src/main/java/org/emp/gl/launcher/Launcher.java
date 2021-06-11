package org.emp.gl.launcher;


import org.emp.gl.gui.MainMenu;
import org.emp.gl.gui.Robot;
import org.emp.gl.layout.MazeGrid;
import org.emp.gl.lookup.Lookup;
import org.emp.gl.time.service.impl.delegation.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerService;

public class Launcher {
    static {
        // Lookup.getInstance().register(TimerService.class, new DummyTimeServiceImpl());
        Lookup.getInstance().register(TimerService.class, new TimerServiceImplWithDelegation());
        Lookup.getInstance().register(MazeGrid.class, new MazeGrid(10,10,10));
        Lookup.getInstance().register(Robot.class, new Robot(Lookup.getInstance().getService(MazeGrid.class)));
    }
        public static void main(String[] args){
            MazeGrid mazeGrid =Lookup.getInstance().getService(MazeGrid.class);
            Robot robot =Lookup.getInstance().getService(Robot.class);
            new MainMenu();
            TimerService ts=Lookup.getInstance().getService(TimerService.class);
            ts.addListener(robot);

        }

}
