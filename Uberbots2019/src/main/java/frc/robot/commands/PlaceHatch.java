package frc.robot.commands;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

public class PlaceHatch extends Command {

    private boolean finished = false;

    public PlaceHatch(){
        requires(Robot.driveTrain);
        requires(Robot.hatchMechanism);

        setInterruptible(true);
    }

    public boolean isFinished(){
        return finished;
    }

    @Override
  protected void execute() {
    // Coast to allow robot to push backwards when hatch hits the wall
    Robot.driveTrain.setNeutralMode(NeutralMode.Coast);

    // Push the hatch out
    Robot.hatchMechanism.HatchRelease();

    // Wait a moment before going back into brake
    Timer.delay(1);
    
    // Resume brake mode
    Robot.driveTrain.setNeutralMode(NeutralMode.Brake);

    // Pull the pistons back in
    Robot.hatchMechanism.HatchRetract();

    finished = true;
  }

}
