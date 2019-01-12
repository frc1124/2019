package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {

    public AutoDrive(){
        requires(Robot.driveTrain);

        setInterruptible(true);
    }  
    @Override
    public void execute(){


    }  

    protected boolean isFinished(){

        return true; 
    }
     protected void interrupted(){

        end();
     }

}