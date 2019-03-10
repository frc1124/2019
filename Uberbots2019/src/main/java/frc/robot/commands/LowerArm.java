package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.OI;

import edu.wpi.first.wpilibj.command.Command;


public class LowerArm extends Command {

	public LowerArm(){
		super("LowerArm");
		requires(Robot.arm);
	}

	public boolean isFinished(){
		return !OI.getJoystick().getRawButton(OI.RIGHT_BUTTON);
	}

	@Override
	protected void execute() {
		Robot.arm.move(-1);
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
