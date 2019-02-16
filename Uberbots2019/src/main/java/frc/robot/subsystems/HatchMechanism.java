package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchMechanism extends Subsystem{

	protected static DoubleSolenoid Push1, Push2, Slide1, Slide2;

	public HatchMechanism(){
		super("HatchMechanism");

		Push1 = new DoubleSolenoid(RobotMap.PUSH1_FORWARD_CHANNEL,RobotMap.PUSH1_BACKWARD_CHANNEL);
		Push2 = new DoubleSolenoid(RobotMap.PUSH2_FORWARD_CHANNEL,RobotMap.PUSH2_BACKWARD_CHANNEL);
		Slide1 = new DoubleSolenoid(RobotMap.SLIDE1_FORWARD_CHANNEL,RobotMap.SLIDE1_BACKWARD_CHANNEL);
		Slide2 = new DoubleSolenoid(RobotMap.SLIDE2_FORWARD_CHANNEL, RobotMap.SLIDE2_BACKWARD_CHANNEL);

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

		Slide1.set(DoubleSolenoid.Value.kForward);
		Slide2.set(DoubleSolenoid.Value.kForward);
		
	}
	public void PistonRetract(){
		Robot.ntData.pistonExtendedEntry.setBoolean(false);
		Slide1.set(DoubleSolenoid.Value.kReverse);
		Slide2.set(DoubleSolenoid.Value.kReverse);
	}
}


