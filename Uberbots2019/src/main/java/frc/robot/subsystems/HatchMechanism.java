package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchMechanism extends Subsystem{
	// public static double isHatchReleased;
	protected static DoubleSolenoid Push1, Push2, Bar;

	public HatchMechanism(){
		super("HatchMechanism");

		Push1 = new DoubleSolenoid(RobotMap.PUSH1_FORWARD_CHANNEL,RobotMap.PUSH1_BACKWARD_CHANNEL);
		Push2 = new DoubleSolenoid(RobotMap.PUSH2_FORWARD_CHANNEL,RobotMap.PUSH2_BACKWARD_CHANNEL);
		Bar = new DoubleSolenoid(RobotMap.BAR_FORWARD_CHANNEL,RobotMap.BAR_BACKWARD_CHANNEL);

	}

	public void initDefaultCommand(){

	}
	public void HatchRelease(){
		Robot.ntData.hatchReleasedEntry.setBoolean(true);

		Push1.set(DoubleSolenoid.Value.kForward);
		Push2.set(DoubleSolenoid.Value.kForward);

	}
	public void HatchRetract(){
		Robot.ntData.hatchReleasedEntry.setBoolean(false);

		Push1.set(DoubleSolenoid.Value.kReverse);
		Push2.set(DoubleSolenoid.Value.kReverse);
	}

	public void PistonExtend(){
		Robot.ntData.pistonExtendedEntry.setBoolean(true);
		Bar.set(DoubleSolenoid.Value.kForward);
	}
	public void PistonRetract(){
		Robot.ntData.pistonExtendedEntry.setBoolean(false);
		Bar.set(DoubleSolenoid.Value.kReverse);
	}
}


