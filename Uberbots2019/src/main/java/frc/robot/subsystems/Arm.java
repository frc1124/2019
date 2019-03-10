package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Arm extends Subsystem{

	// TODO: Change value/Pray to RNJesus
	private double DELTA_OHMS = 62.5;
	private double ANGLE_ROTATION = 45;

	private int kTimeoutMs = 20;
	private int kArcadeProfile = 0;

	protected static WPI_TalonSRX arm;

	protected static SpeedControllerGroup armSC;

	protected final double THROTTLE = .01;

	public Arm(){
		super("Arm");
		
		arm = new WPI_TalonSRX(RobotMap.ARM); //Check device numbers
		armSC = new SpeedControllerGroup(arm);
	}

	// 0 to 360
	public void move(double y){
		armSC.set(y * THROTTLE);
	}

	public void stop() {
		armSC.stopMotor();
	}

	@Override
	public void initDefaultCommand(){
	
	}
}