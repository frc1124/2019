package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveJoystick extends Command {

  public ArcadeDriveJoystick(){
    requires(Robot.driveTrain);

    setInterruptible(true);
  }

  @Override
  protected void initialize() {
    
  }

  @Override
  protected void execute() {    
    Joystick js = Robot.oi.getJoystick();

    Robot.driveTrain.drive(js);
  }

    @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.driveTrain.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}