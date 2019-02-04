package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveJoystick;

// Check for error here
//import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.kauailabs.navx.frc.AHRS;

public class PIDDrive extends Subsystem{

	// Find out what the 120 means
	private final double ENCODER_DIST_PER_PULSE = (Math.PI / 4096);

	protected static WPI_TalonSRX leftBack, leftFront;
	protected static WPI_TalonSRX rightBack, rightFront;

    public AHRS navx = new AHRS(SPI.Port.kMXP);

	protected static SpeedControllerGroup left, right;

	protected static DifferentialDrive diffDrive;

	protected final double THROTTLE = .75;


	private long kTimeoutMs = 20;
	private int kArcadeProfile = 0;

	public PIDDrive(){
        super("PIDDrive");

		// Set up the left side
		leftFront = new WPI_TalonSRX(RobotMap.LEFT_1);
		leftBack = new WPI_TalonSRX(RobotMap.LEFT_2);
		leftBack.follow(leftFront);
		leftFront.config_kP(kArcadeProfile,RobotMap.LEFT_P);
		leftFront.config_kI(kArcadeProfile,RobotMap.LEFT_I);
		leftFront.config_kD(kArcadeProfile,RobotMap.LEFT_D);
		leftFront.config_kF(kArcadeProfile,RobotMap.LEFT_F);
		leftFront.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,kTimeoutMs);

		// Set up the right side
		rightFront = new WPI_TalonSRX(RobotMap.RIGHT_1);
		rightBack = new WPI_TalonSRX(RobotMap.RIGHT_2);
		rightBack.follow(rightFront);
		rightFront.config_kP(kArcadeProfile,RobotMap.RIGHT_P);
		rightFront.config_kI(kArcadeProfile,RobotMap.RIGHT_I);
		rightFront.config_kD(kArcadeProfile,RobotMap.RIGHT_D);
		rightFront.config_kF(kArcadeProfile,RobotMap.RIGHT_F);
		rightFront.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,kTimeoutMs);

		resetEncoders();
		resetNavx();
	}

	@Override
	public void initDefaultCommand(){
		setDefaultCommand(new ArcadeDriveJoystick());
	}
/*
	public void drive(double move, double rotate){
		// Robot.ntData.arcadeDriveMoveEntry.getDouble(move);
		// Robot.ntData.arcadeDriveRotateEntry.getDouble(rotate);
		/diffDrive.arcadeDrive(move, rotate);
	}

	public void drive(Joystick joystick){
		this.drive(THROTTLE * -joystick.getY(), THROTTLE * -joystick.getX());
	}

	public void stop(){
		this.drive(0,0);
	}
*/

	public void stop(){
		leftFront.setMotorOutputPercent(0.0);
		rightFront.setMotorOutputPercent(0.0);
	}

	public void resetNavx(){
		navx.reset();
	}
	

	/**
	 * Goes beyond 360 degrees
	 * @return absolute full angle that is beyond 360 degrees after 1 rotation
	 */
	public double getFullAngle(){
		return navx.getAngle();
	}

	/**
	 * Angle is between 0 and 360 degrees
	 */
	public double getAngle(){
		return navx.getAngle() / 360.0;
	}
	public float getYaw(){
		return navx.getYaw();
	}

	public double getAngularRate(){
		return navx.getRate();
	}

	// accelerometer methods

	public double getAccelX(){
		return navx.getWorldLinearAccelX();
	}

	public double getAccelY(){
		return navx.getWorldLinearAccelY();
	}

	public double getAccelZ(){
		return navx.getWorldLinearAccelZ();
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

	public static void setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode mode) {
		leftFront.setNeutralMode(mode);
		rightFront.setNeutralMode(mode);
	}
}
