package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.RobotMap;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Elevator extends Subsystem{

	private int TIMEOUT = 500;

	public double DISTANCE_PER_TICK = (2/25.4) / 4096; // measuring height at 2mm per round, in inches

	protected static WPI_TalonSRX shaft, slave;

	protected static SpeedControllerGroup shaftSC;

	protected final double THROTTLE = .25;

	private int kTimeoutMs = 20;
	private int kArcadeProfile = 0;

	private static boolean raiseElevator = true;

	public Elevator(){
        super("Elevator");

		// Set up the left side
		shaft = new WPI_TalonSRX(RobotMap.ELEVATOR1);
		/*
		shaft.config_kP(kArcadeProfile,RobotMap.ELEVATOR_P);
		shaft.config_kI(kArcadeProfile,RobotMap.ELEVATOR_I);
		shaft.config_kD(kArcadeProfile,RobotMap.ELEVATOR_D);
		shaft.config_kF(kArcadeProfile,RobotMap.ELEVATOR_F);
		shaft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,kTimeoutMs);
		*/
		slave = new WPI_TalonSRX(RobotMap.ELEVATOR2);
		slave.follow(shaft);
		
		shaftSC = new SpeedControllerGroup(shaft, slave);
		System.out.println("Init");
		//resetEncoder();
	}

	@Override
	public void initDefaultCommand(){
		//setDefaultCommand(new ElevatorJoystick());
	}

	public void usePID(boolean enablePID) {
		if (enablePID) {
			shaft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, kTimeoutMs);
		} else {
			shaft.configSelectedFeedbackSensor((FeedbackDevice)null, 0, kTimeoutMs);
		}
	}

    /*
	public void move(double distance) {
		setPosition(distance);
	}
	*/

	public void stop(){
		shaftSC.stopMotor();
	}

	public static void setNeutralMode(NeutralMode mode) {
		shaft.setNeutralMode(mode);
		slave.setNeutralMode(mode);
	}
	
	// manual drive

	public void shaftManual(double speed) {
		shaftSC.set(speed);
	}
	/*
	public void setVelocity(double velocity) {
		shaft.set(ControlMode.Velocity, velocity);
	}

	public void setPosition(double distance) {
		shaft.set(ControlMode.Position, distance / DISTANCE_PER_TICK);
	}

	// encoder methods
	
	public double getEncoderDistance(){
		return shaft.getSensorCollection().getQuadraturePosition();
	}
	
	public double getEncoderVelocity(){
		return shaft.getSensorCollection().getQuadratureVelocity();
	}

	public void resetEncoder(){
		shaft.getSensorCollection().setQuadraturePosition(0, TIMEOUT);
	}
	*/

	public static boolean getRaiseElevator(){
		return raiseElevator;
}

	public void set(double speed) {
		shaftSC.set(speed * THROTTLE);
	}
	
	public void moveUp(boolean up) {
		set(up ? 1 : -1);
	}

	public String log(){
		
		return "shaftSC - " + shaftSC.get() + " - shaft - " + shaft.get() + " - Start Time - " + System.currentTimeMillis();
	}
}
