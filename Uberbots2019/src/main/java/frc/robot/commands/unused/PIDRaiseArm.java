package frc.robot.commands.unused;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;


// Suggestion: Put this on a joystick so the arm speed can be controlled. The arm should move slower as it gets closer to its target position.
public class PIDRaiseArm extends PIDCommand {
	//private double TOLERANCE = 0.05;
	//private double setPoint = 180;

	public PIDRaiseArm(){
		super("PIDRaiseArm",RobotMap.ARM_P,RobotMap.ARM_I,RobotMap.ARM_D);
		requires(Robot.arm);
	}

	public boolean isFinished(){
		return false;// return Math.abs(Robot.arm.getAngle() - setPoint) <= TOLERANCE;
	}

	@Override
	protected void execute() {
		Robot.arm.move(1);
	}

	public double returnPIDInput(){
		return 0; // return Robot.arm.getAngle();
	}
	public void usePIDOutput(double output) {
	}

}
