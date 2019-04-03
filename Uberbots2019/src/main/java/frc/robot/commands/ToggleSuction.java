package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class ToggleSuction extends Command{
    private boolean hasToggled = false;
    
    public ToggleSuction(){
        requires(Robot.suctionCup);

        setInterruptible(true);
    }
    
    public void execute(){
        System.out.println("execute suction");
        Robot.suctionCup.toggle();
        hasToggled = true;
    }


    protected boolean isFinished(){    
        return hasToggled;
    }
}

