package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class ToggleSuction extends Command{
    
    public ToggleSuction(){
        //requires(Robot.suctionCup);

        setInterruptible(true);
    }
    
    public void execute(){
        Robot.suctionCup.toggle();

    }
    protected boolean isFinished(){
        return false;
    }
}

