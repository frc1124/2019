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

import com.kauailabs.navx.frc.AHRS;

public class Elevator extends Subsystem{

	private int TIMEOUT = 500;

	public double DISTANCE_PER_TICK = Math.PI / 4096;

	protected static WPI_TalonSRX shaft, slave;

	protected static SpeedControllerGroup shaftSC;

	protected final double THROTTLE = .75;

	private int kTimeoutMs = 20;
	private int kArcadeProfile = 0;

	public Elevator(){
        super("Elevator");

		// Set up the left side
		shaft = new WPI_TalonSRX(RobotMap.ELEVATOR1);
		shaft.config_kP(kArcadeProfile,RobotMap.ELEVATOR_P);
		shaft.config_kI(kArcadeProfile,RobotMap.ELEVATOR_I);
		shaft.config_kD(kArcadeProfile,RobotMap.ELEVATOR_D);
		shaft.config_kF(kArcadeProfile,RobotMap.ELEVATOR_F);
		shaft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,kTimeoutMs);

		slave = new WPI_TalonSRX(RobotMap.ELEVATOR2);
		slave.follow(shaft);
		
		resetEncoder();
	}

	@Override
	public void initDefaultCommand(){
		//setDefaultCommand(new ElevatorJoystick());
	}

	public void move(double distance) {
		setPosition(distance);
	}

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
}
