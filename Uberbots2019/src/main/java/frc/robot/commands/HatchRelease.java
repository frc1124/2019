package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HatchRelease extends Command {

    public HatchRelease(){
        requires(Robot.hatchMechanism);

        setInterruptible(true);
    }

    public boolean isFinished(){
        return false;
    }

    @Override
  protected void execute() {

    Robot.hatchMechanism.HatchRelease();
  }

}
