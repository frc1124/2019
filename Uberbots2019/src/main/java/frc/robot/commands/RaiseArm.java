package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.OI;

import edu.wpi.first.wpilibj.command.Command;


// Suggestion: Put this on a joystick so the arm speed can be controlled. The arm should move slower as it gets closer to its target position.
public class RaiseArm extends Command {

	public RaiseArm(){
		super("RaiseArm");
		requires(Robot.arm);
	}

	public boolean isFinished(){
		return !OI.getJoystick().getRawButton(OI.LEFT_BUTTON);
	}

	@Override
	protected void execute() {
		Robot.arm.move(1);
	}

	@Override
	public void end() {
		Robot.arm.stop();
	}


	@Override
	public void interrupted() {
		Robot.arm.stop();
	}

}
