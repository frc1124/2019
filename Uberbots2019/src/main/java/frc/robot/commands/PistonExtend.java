package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PistonExtend extends Command{
    
    public PistonExtend(){
        requires(Robot.hatchMechanism);

        setInterruptible(true);
    }
    
    public void execute(){
        Robot.hatchMechanism.PistonExtend();

    }
    protected boolean isFinished(){
        return false;
    }
}

