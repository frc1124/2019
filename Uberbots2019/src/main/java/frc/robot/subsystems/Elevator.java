package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogPotentiometer;


import frc.robot.RobotMap;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Elevator extends Subsystem{

	private int TIMEOUT = 500;

	// TODO: get value
	private double DISTANCE_PER_TICK = Math.PI / 4096;
	private double ANG_OFFSET = 0;

	protected static WPI_TalonSRX shaft;
	protected static AnalogPotentiometer potentiometer;

	protected final double THROTTLE = .75;


	private int kTimeoutMs = 20;

	public Elevator(){
        super("Elevator");

		// Set up the shaft
		// TODO: create robotmap value
		// shaft = new WPI_TalonSRX(RobotMap.SHAFT_1);
		// shaft.config_kP(kArcadeProfile,RobotMap.SHAFT_P);
		// shaft.config_kI(kArcadeProfile,RobotMap.SHAFT_I);
		// shaft.config_kD(kArcadeProfile,RobotMap.SHAFT_D);
		// shaft.config_kF(kArcadeProfile,RobotMap.SHAFT_F);
		// shaft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,kTimeoutMs);
		
		// Set up sensors/meters
		// potentiometer = new AnalogPotentiometer(RobotMap.POTENTIOMETER, 360, ANG_OFFSET);

	}

	@Override
	public void initDefaultCommand(){
		// setDefaultCommand(new <INSERT COMMAND HERE>);
	}

	public void manualMove(double speed) {
		shaft.set(speed);
	}


	// velocity is position change / 100ms
	public void moveShaftVelocity(double velocity) {
		shaft.set(ControlMode.Velocity, velocity);
	}

	// Distance in feet
	public void moveShaftPosition(double distance) {
		shaft.set(ControlMode.Position, distance / DISTANCE_PER_TICK);
	}

	public void setNeutralMode() {
	
	}

}
