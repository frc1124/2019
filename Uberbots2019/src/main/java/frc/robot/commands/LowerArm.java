package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;


public class LowerArm extends PIDCommand {
	private double TOLLERANCE = 0.05;
	private double setPoint = 180;

	public LowerArm(){
		super("LowerArm",RobotMap.ARM_P,RobotMap.ARM_I,RobotMap.ARM_D);
		requires(Robot.arm);
	}

	public boolean isFinished(){
		return Math.abs(Robot.arm.getAngle() - setPoint) <= TOLLERANCE;
	}

	@Override
	protected void execute() {
		Robot.arm.move(-1);
	}

	public double returnPIDInput(){
		return Robot.arm.getAngle();
	}
	public void usePIDOutput(double output) {
	}

}
