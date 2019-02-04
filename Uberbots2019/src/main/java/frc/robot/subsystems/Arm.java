package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Arm extends Subsystem{

	protected static WPI_TalonSRX arm;

	protected static SpeedControllerGroup armSCGroup;


	protected final double THROTTLE = .75;


	public Arm(){
		super("Arm");
		//arm = new WPI_TalonSRX(RobotMap.ARM); //Check device numbers
		armSCGroup = new SpeedControllerGroup(arm);
	}

	public void moveArm(double y){
		armSCGroup.set(y);
	}
	public void stop() {
		armSCGroup.stopMotor();
	}

	@Override
	public void initDefaultCommand(){
	
	}
}


