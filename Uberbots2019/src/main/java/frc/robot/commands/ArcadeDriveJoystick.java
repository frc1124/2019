package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;


public class ArcadeDriveJoystick extends Command {
  private final int IMAGE_WIDTH = 320;

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

  /*
    // if target button is held, steer with vision
    if (js.getRawButtonPressed(OI.RIGHT_BUTTON)) {
        // Get data from NetworkTables from Raspberry Pi
        double centerX = Robot.ntData.getVisionData("centerX");

        // Make sure we found a target
        if (centerX > 0) {
          // Steer towards center by altering rotation
          double x = (centerX - IMAGE_WIDTH/2) / IMAGE_WIDTH;
          double y = js.getY();
          Robot.driveTrain.drive(y,x);
          return;
      }
    }
*/
    // Default drive
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