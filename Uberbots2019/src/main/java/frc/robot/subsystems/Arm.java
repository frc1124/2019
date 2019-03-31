package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Arm extends Subsystem{
	// TODO: Change value/Pray to RNJesus
//	private double DELTA_OHMS = 62.5;
//	private double ANGLE_ROTATION = 45;
//	private int kTimeoutMs = 20;
//	private int kArcadeProfile = 0;

	protected WPI_TalonSRX arm;
	protected SpeedControllerGroup armSC;
	protected AnalogPotentiometer pot;

	private static final double ANGLE_PER_OHM = 0.72;
	protected final double THROTTLE = .75;

	public Arm(){
		super("Arm");
		
		arm = new WPI_TalonSRX(RobotMap.ARM); //Check device numbers
		armSC = new SpeedControllerGroup(arm);

		pot = new AnalogPotentiometer(RobotMap.POT, 3600, 0);
	}

	@Override
	public void initDefaultCommand(){
	
	}

	// 0 to 360
	public void move(double y){
		armSC.set(y * THROTTLE);
	}

	public void stop() {
		armSC.stopMotor();
	}

	public double potGet() {
		return pot.get();
	}

	public double getAngle() {
		return (pot.get() / ANGLE_PER_OHM) - 40; // assuming 0 degrees on pot is at pickup position
	}
}