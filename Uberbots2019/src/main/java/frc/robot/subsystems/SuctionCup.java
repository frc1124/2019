package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SuctionCup extends Subsystem{
	// public static double isHatchReleased;
	protected static Solenoid solenoid;

	public SuctionCup(){
		super("SuctionCup");

		solenoid = new Solenoid(RobotMap.SOLENOID_CHANNEL);
	}

	public void initDefaultCommand(){

	}
	public void suck(){
		solenoid.set(true);
	}

	public void stop(){
		solenoid.set(false);
	}
}


