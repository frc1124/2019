package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleHatch extends Command {

    public ToggleHatch(){
        requires(Robot.hatchMechanism);

        setInterruptible(true);
    }

    public boolean isFinished(){
        return false;
    }

    @Override
  protected void execute() {

    Robot.hatchMechanism.HatchToggle();
  }

}
