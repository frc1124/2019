package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchMechanism extends Subsystem{

	protected DoubleSolenoid Push, Slide;

	public HatchMechanism(){
		super("HatchMechanism");

		Push = new DoubleSolenoid(RobotMap.PUSH_FORWARD_CHANNEL, RobotMap.PUSH_BACKWARD_CHANNEL);
		Slide = new DoubleSolenoid(RobotMap.SLIDE_FORWARD_CHANNEL, RobotMap.SLIDE_BACKWARD_CHANNEL);
	}

	public void initDefaultCommand(){

	}

	public void HatchRelease(){
		Robot.ntData.hatchReleasedEntry.setBoolean(true);

		Push.set(DoubleSolenoid.Value.kForward);
	}

	public void HatchRetract(){
		Robot.ntData.hatchReleasedEntry.setBoolean(false);

		Push.set(DoubleSolenoid.Value.kReverse);
	}

	public DoubleSolenoid.Value getHatchStatus(){
		return Push.get();
	}

	public void HatchToggle(){
		switch(Push.get()){
			case kReverse: Push.set(DoubleSolenoid.Value.kForward); break;
			case kForward: Push.set(DoubleSolenoid.Value.kReverse); break;
			case kOff: Push.set(DoubleSolenoid.Value.kForward); break;
		}
		Robot.ntData.hatchReleasedEntry.setBoolean(getHatchStatus() == DoubleSolenoid.Value.kReverse ? true : false);
	}

	public void PistonExtend(){
		Robot.ntData.pistonExtendedEntry.setBoolean(true);

		Slide.set(DoubleSolenoid.Value.kForward);		
	}

	public void PistonRetract(){
		Robot.ntData.pistonExtendedEntry.setBoolean(false);
		
		Slide.set(DoubleSolenoid.Value.kReverse);
	}

	public DoubleSolenoid.Value getPistonStatus(){
		return Slide.get();
	}

	public void PistonToggle(){
		switch(Slide.get()){
			case kReverse: Slide.set(DoubleSolenoid.Value.kForward); break;
			case kForward: Slide.set(DoubleSolenoid.Value.kReverse); break;
			case kOff: Slide.set(DoubleSolenoid.Value.kForward); break;
		}
		Robot.ntData.pistonExtendedEntry.setBoolean(getPistonStatus() != DoubleSolenoid.Value.kReverse ? true : false);
	}
}


