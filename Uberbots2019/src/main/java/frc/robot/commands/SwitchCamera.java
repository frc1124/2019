package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwitchCamera extends Command{

    private boolean finished = false;

    public SwitchCamera(){
        requires(Robot.camera);
    }

    public void execute(){
        Robot.camera.setCurrentCamera(Robot.camera.getCurrentCamera());
        finished = true;
    }

    @Override
    public boolean isFinished(){
        return finished;
    }

}