package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SuctionCup extends Subsystem{
	// public static double isHatchReleased;
	protected static DoubleSolenoid suctionSol;

	public SuctionCup(){
		super("SuctionCup");

		suctionSol = new DoubleSolenoid(RobotMap.SUCTION_FORWARDS_CHANNEL,  RobotMap.SUCTION_BACKWARDS_CHANNEL);
	}

	public void initDefaultCommand(){

	}
	public void suck(){
		suctionSol.set(DoubleSolenoid.Value.kForward);
	}

	public void stop(){
		suctionSol.set(DoubleSolenoid.Value.kReverse);
	}
}


