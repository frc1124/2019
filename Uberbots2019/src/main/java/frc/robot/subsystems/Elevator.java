package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Encoder;


import frc.robot.RobotMap;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Elevator extends PIDSubsystem{

	private int TIMEOUT = 500;

	// TODO: get value
	private double DISTANCE_PER_TICK = Math.PI / 4096;
	private double ANG_OFFSET = 0;

	protected static PWMSpeedController shaft;

	protected static Encoder enc;

	protected final double THROTTLE = .75;

	private int kTimeoutMs = 20;

	public Elevator(){
       super("Elevator",
       		   RobotMap.ELEVATOR_P,
       		   RobotMap.ELEVATOR_I,
			   RobotMap.ELEVATOR_D,
			   RobotMap.ELEVATOR_F
       		   );

		// Set up the shaft
		// TODO: create robotmap value
		// shaft = new PWMSpeedController(RobotMap.SHAFT_1);

		// Set up sensors/meters
		// enc = new Encoder(RobotMap.ARM_ENCODER);

	}

	@Override
	public void initDefaultCommand(){
		// setDefaultCommand(new <INSERT COMMAND HERE>);
	}

	public void setSpeed(double speed) {
		shaft.set(speed);
	}
	
	public double returnPIDInput() {
		return enc.getDistance();
	}

	@Override
	public void usePIDOutput(double output) {
	}

}
