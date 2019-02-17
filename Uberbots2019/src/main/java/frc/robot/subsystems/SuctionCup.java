package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SuctionCup extends Subsystem{
	
	protected Solenoid suctionSol;

	public SuctionCup(){
		super("SuctionCup");

		suctionSol = new Solenoid(RobotMap.SUCTION_CHANNEL);
	}

	public void initDefaultCommand(){

	}
	public void suck(){
		suctionSol.set(true);
	}

	public void stop(){
		suctionSol.set(false);
	}
}


