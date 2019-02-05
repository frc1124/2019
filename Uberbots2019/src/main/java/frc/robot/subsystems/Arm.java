package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Arm extends Subsystem{

	protected static WPI_TalonSRX arm;

	protected static SpeedControllerGroup armSCGroup;

	protected static AnalogPotentiometer pot;
	private double ANG_OFFSET = 0;

	protected final double THROTTLE = .75;


	public Arm(){
		super("Arm");
		//arm = new WPI_TalonSRX(RobotMap.ARM); //Check device numbers
		armSCGroup = new SpeedControllerGroup(arm);

		// pot = new AnalogPotentiometer(RobotMap.POTENTIOMETER, 360, ANG_OFFSET);
	}

	// 0 to 360
	public void move(double y){
		armSCGroup.set(y * THROTTLE);
	}

	public void stop() {
		armSCGroup.stopMotor();
	}

	public double getAngle(){
		return pot.get();
	}


	@Override
	public void initDefaultCommand(){
	
	}
}


