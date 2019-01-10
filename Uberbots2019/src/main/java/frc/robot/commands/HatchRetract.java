package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HatchRetract extends Command{

    public HatchRetract(){
        requires(Robot.hatchMechanism);

        setInterruptible(true);
    }

    public void initDefaultCommand(){

    }

    public void execute(){
        Robot.hatchMechanism.HatchRetract();

    }
    public boolean isFinished(){
        return false;
    }

}