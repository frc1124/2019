package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveJoystick;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drive extends Subsystem{

	private Encoder leftEncoder;
	private Encoder rightEncoder;

	// Find out what the 120 means
	private final double ENCODER_DIST_PER_PULSE = Math.PI / 120;

	protected static WPI_TalonSRX leftBack, leftFront;
	protected static WPI_TalonSRX rightBack, rightFront;

	private AnalogGyro gyro;
	private BuiltInAccelerometer accel;

	protected static SpeedControllerGroup left, right;

	protected static DifferentialDrive diffDrive;

	protected final double THROTTLE = .75;

	public Drive(){
		super("Drive");
		leftBack = new WPI_TalonSRX(RobotMap.LEFT_1); //Check device numbers
		leftFront = new WPI_TalonSRX(RobotMap.LEFT_2);
		left = new SpeedControllerGroup(leftBack, leftFront);

		rightBack = new WPI_TalonSRX(RobotMap.RIGHT_1);
		rightFront = new WPI_TalonSRX(RobotMap.RIGHT_2);
		right = new SpeedControllerGroup(rightBack, rightFront);

		diffDrive = new DifferentialDrive(left, right);



		int leftBackChannel = RobotMap.LEFT_DRIVE_BACK;
		int leftFrontChannel = RobotMap.LEFT_DRIVE_FRONT;
		int rightBackChannel = RobotMap.RIGHT_DRIVE_BACK;
		int rightFrontChannel = RobotMap.RIGHT_DRIVE_FRONT;
		leftEncoder = new Encoder(leftBackChannel, leftFrontChannel, false, EncodingType.k4X);

		rightEncoder = new Encoder(rightBackChannel, rightFrontChannel, false, EncodingType.k4X);

		rightEncoder.setDistancePerPulse(ENCODER_DIST_PER_PULSE);
		leftEncoder.setDistancePerPulse(ENCODER_DIST_PER_PULSE);

		gyro = new AnalogGyro(RobotMap.GYRO);
		gyro.initGyro();

		accel = new BuiltInAccelerometer();
	}

	@Override
	public void initDefaultCommand(){
		setDefaultCommand(new ArcadeDriveJoystick());
	}

	public void drive(double move, double rotate){
		diffDrive.arcadeDrive(move, rotate);
	}

	public void drive(Joystick joystick){
		this.drive(THROTTLE * -joystick.getY(), THROTTLE * -joystick.getX());
	}

	public void stop(){
		diffDrive.arcadeDrive(0, 0);
	}

	public void resetGyro(){
		gyro.reset();
	}

	/**
	 * Goes beyond 360 degrees
	 * @return absolute full angle that is beyond 360 degrees after 1 rotation
	 */
	public double getFullAngle(){
		return gyro.getAngle();
	}

	/**
	 * Angle is between 0 and 360 degrees
	 */
	public double getAngle(){
		return gyro.getAngle() / 360.0;
	}

	public double getAngularRate(){
		return gyro.getRate();
	}

	// accelerometer methods

	public double getAccelX(){
		return accel.getX();
	}

	public double getAccelY(){
		return accel.getY();
	}

	public double getAccelZ(){
		return accel.getZ();
	}

	// encoder methods
	public double getLeftEncoderDistance(){
		return leftEncoder.getDistance();
	}
	
	public boolean getLeftEncoderDirection(){
		return leftEncoder.getDirection();
	}
	
	public double getLeftEncoderRate(){
		return leftEncoder.getRate();
	}
	
	public boolean getLeftEncoderStopped(){
		return leftEncoder.getStopped();
	}
	public double getRightEncoderDistance(){
		return rightEncoder.getDistance();
	}

	public boolean getRightEncoderDirection(){
		return rightEncoder.getDirection();
	}

	public double getRightEncoderRate(){
		return rightEncoder.getRate();
	}

	public boolean getRightEncoderStopped(){
		return rightEncoder.getStopped();
	}

	public void resetEncoders(){
		resetLeftEncoder();
		resetRightEncoder();
	}

	public void resetLeftEncoder(){
		leftEncoder.reset();
	}

	public void resetRightEncoder(){
		rightEncoder.reset();
	}

}
