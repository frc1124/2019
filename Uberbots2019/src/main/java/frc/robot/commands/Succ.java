package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class Succ extends Command{
    
    public Succ(){
        requires(Robot.suctionCup);

        setInterruptible(true);
    }
    
    public void execute(){
        Robot.suctionCup.suck();

    }
    protected boolean isFinished(){
        return false;
    }
}

