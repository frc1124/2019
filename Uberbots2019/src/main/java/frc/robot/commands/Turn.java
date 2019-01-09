/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.PIDController;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * An example command.  You can replace me with your own command.
 */
public class Turn extends PIDCommand {

	public static WPI_TalonSRX leftBack, leftFront;
	public static WPI_TalonSRX rightBack, rightFront;


	private static final double MAX_SPEED = 1;

	public double voltage = 0;

	private double angle = 0;
	private double currentAngle = 0;

	public final double SETPOINT_TOLERANCE = 2.0;
	
	private final double UNITS_PER_TICK = 10.0 * 60.0 / 4096.0;

	private BuiltInAccelerometer accel;
	

	private static final double P = 0;
	private static final double I = 0;
	private static final double D = 0;

	public AnalogGyro gyro;
	public DifferentialDrive robotDrive;

	public double startPoint;
	// Degrees range from 180 to -179
	public Turn(double angle) {
		super("Turn", P, I, D);
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);

		leftBack = new WPI_TalonSRX(RobotMap.LEFT_2);
		leftFront = new WPI_TalonSRX(RobotMap.LEFT_1);
		rightBack = new WPI_TalonSRX(RobotMap.RIGHT_2);
		rightFront = new WPI_TalonSRX(RobotMap.RIGHT_1);

		this.angle = angle;

		this.getPIDController().setOutputRange(-MAX_SPEED, MAX_SPEED);

		gyro = new AnalogGyro(RobotMap.GYRO);
		gyro.initGyro();
		accel = new BuiltInAccelerometer();

		int leftBackChannel = RobotMap.LEFT_DRIVE_BACK;
		int leftFrontChannel = RobotMap.LEFT_DRIVE_FRONT;
		int rightBackChannel = RobotMap.RIGHT_DRIVE_BACK;
		int rightFrontChannel = RobotMap.RIGHT_DRIVE_FRONT;



		startPoint = Robot.driveTrain.getAngle();

		setInterruptible(true);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setSetpoint(angle);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.driveTrain.getAngle() - startPoint) <= SETPOINT_TOLERANCE;
    }

	// Called once after isFinished returns true
	@Override
    protected void end() {
		// Stop drivetrain
    	
    	this.getPIDController().reset();
    }


	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		// add debug info here
		end();
	}
	public double getAngle() {
		return currentAngle;
	}

	public PIDController getPID(){
		return this.getPIDController();
	}

	protected double returnPIDOutput() {
		return Robot.driveTrain.getAngle();
	}

	protected void usePIDOutput(double output) {
		Robot.driveTrain.drive(0,output);
	}

	protected double returnPIDInput() {
		return Robot.driveTrain.getAngle();
	}
}
