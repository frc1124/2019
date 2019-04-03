package frc.robot.commands.unused;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class PistonRetract extends Command{
    
    public PistonRetract(){
        requires(Robot.hatchMechanism);

        setInterruptible(true);
    }
    
    public void execute(){
        Robot.hatchMechanism.PistonRetract();

    }
    protected boolean isFinished(){
        return false;
    }
}
