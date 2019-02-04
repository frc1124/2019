package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.RobotMap;
import frc.robot.Robot;
import frc.robot.commands.ArcadeDriveJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import com.kauailabs.navx.frc.AHRS;

public class PIDDrive extends Subsystem{

	private int TIMEOUT = 500;

	protected static WPI_TalonSRX leftBack, leftFront;
	protected static WPI_TalonSRX rightBack, rightFront;

    public AHRS navx = new AHRS(SPI.Port.kMXP);

	protected static SpeedControllerGroup left, right;

	protected static DifferentialDrive diffDrive;

	protected final double THROTTLE = .75;


	private int kTimeoutMs = 20;
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
	public void drive(double move, double rotate){

		Robot.ntData.arcadeDriveMoveEntry.setDouble(move);
		Robot.ntData.arcadeDriveRotateEntry.setDouble(rotate);

		diffDrive.arcadeDrive(move, rotate);
	}

	public void drive(Joystick joystick){
		this.drive(THROTTLE * -joystick.getY(), THROTTLE * -joystick.getX());
	}

	public void stop(){
		drive(0,0);
	}
	
	// manual drive
	public void leftMove() {}
	public void rightMove() {}

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
		return leftFront.getSensorCollection().getQuadraturePosition();
	}
	
	public double getRightEncoderDistance(){
		return rightFront.getSensorCollection().getQuadraturePosition();
	}

	public double getLeftEncoderVelocity(){
		return leftFront.getSensorCollection().getQuadratureVelocity();
	}
	
	public double getRightEncoderVelocity(){
		return rightFront.getSensorCollection().getQuadratureVelocity();
	}

	public void resetEncoders(){
		rightFront.getSensorCollection().setQuadraturePosition(0, TIMEOUT);
		leftFront.getSensorCollection().setQuadraturePosition(0, TIMEOUT);
	}

	public static void setNeutralMode(NeutralMode mode) {
		leftFront.setNeutralMode(mode);
		rightFront.setNeutralMode(mode);
	}
}
