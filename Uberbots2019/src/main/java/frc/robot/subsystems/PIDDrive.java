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
import frc.robot.Robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.kauailabs.navx.frc.AHRS;

public class PIDDrive extends Subsystem{

	private Gearbox leftGearbox;
	private Gearbox rightGearbox;

	private Encoder leftEncoder;
	private Encoder rightEncoder;

	// Find out what the 120 means
	private final double ENCODER_DIST_PER_PULSE = Math.PI / 120;

	protected static WPI_TalonSRX leftBack, leftFront;
	protected static WPI_TalonSRX rightBack, rightFront;

    public AHRS navx = new AHRS(SPI.Port.kMXP);

	protected static SpeedControllerGroup left, right;

	protected static DifferentialDrive diffDrive;

	protected final double THROTTLE = .75;

	public Drive(){
        super("PIDDrive");

		// Set up the left side
		leftFront = new WPI_TalonSRX(RobotMap.LEFT_2);
		leftBack = new WPI_TalonSRX(RobotMap.LEFT_1); //Check device numbers
		int leftBackChannel = RobotMap.LEFT_DRIVE_BACK;
		int leftFrontChannel = RobotMap.LEFT_DRIVE_FRONT;
		leftEncoder = new Encoder(leftBackChannel, leftFrontChannel, false, EncodingType.k4X);
		leftEncoder.setDistancePerPulse(ENCODER_DIST_PER_PULSE);
		leftGearbox = new Gearbox(leftFront,leftBack,leftEncoder,RobotMap.LEFT_P,RobotMap.LEFT_I,RobotMap.LEFT_D,RobotMap.LEFT_FEEDFORWARD);

		// Set up the right side
		rightFront = new WPI_TalonSRX(RobotMap.RIGHT_2);
		rightBack = new WPI_TalonSRX(RobotMap.RIGHT_1);
		int rightBackChannel = RobotMap.RIGHT_DRIVE_BACK;
        int rightFrontChannel = RobotMap.RIGHT_DRIVE_FRONT;
		rightEncoder = new Encoder(rightBackChannel, rightFrontChannel, false, EncodingType.k4X);
		rightEncoder.setDistancePerPulse(ENCODER_DIST_PER_PULSE);
		rightGearbox = new Gearbox(rightFront,rightBack,rightEncoder,RobotMap.RIGHT_P,RobotMap.RIGHT_I,RobotMap.RIGHT_D,RobotMap.RIGHT_FEEDFORWARD);


		// Set up the differential        
		left = leftGearbox.getSpeedControllerGroup();
		right = rightGearbox.getSpeedControllerGroup();
		diffDrive = new DifferentialDrive(left, right);
	}

	@Override
	public void initDefaultCommand(){
		setDefaultCommand(new ArcadeDriveJoystick());
	}

	public void drive(double move, double rotate){
		// Robot.ntData.arcadeDriveMoveEntry.getDouble(move);
		// Robot.ntData.arcadeDriveRotateEntry.getDouble(rotate);
		diffDrive.arcadeDrive(move, rotate);
	}

	public void drive(Joystick joystick){
		this.drive(THROTTLE * -joystick.getY(), THROTTLE * -joystick.getX());
	}

	public void stop(){
		this.drive(0,0);
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

	public void setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode mode) {
		this.leftGearbox.getFront().setNeutralMode(mode);
		this.leftGearbox.getBack().setNeutralMode(mode);
		this.rightGearbox.getFront().setNeutralMode(mode);
		this.rightGearbox.getBack().setNeutralMode(mode);
	}
}
