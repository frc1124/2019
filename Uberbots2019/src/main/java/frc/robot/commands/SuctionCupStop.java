package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class SuctionCupStop extends Command{
    
    public SuctionCupStop(){
        //requires(Robot.suctionCup);

        setInterruptible(true);
    }
    
    public void execute(){
        Robot.suctionCup.stop();

    }
    protected boolean isFinished(){
        return false;
    }
}

