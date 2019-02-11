package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;


public class RaiseArm extends Command {
	private double THROTTLE = -0.75;

	protected static DigitalInput forwardLimitSwitch;

	public RaiseArm(){
        //requires(Robot.arm);

		//forwardLimitSwitch = new DigitalInput(RobotMap.ARM_LIMIT_FORWARD);
	
        setInterruptible(true);
    }

    public boolean isFinished(){
        return forwardLimitSwitch.get();
    }

    @Override
  protected void execute() {
    //Robot.arm.moveArm(THROTTLE);
  }

}
