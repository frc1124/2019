/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.PIDController;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RightDrive extends PIDCommand {

	public static WPI_TalonSRX rightBack, rightFront;

	private double SETPOINT_TOLERANCE = 2.0;
	private double startPoint;

	private static final double MAX_SPEED = 1;

	public double voltage = 0;

	private double speed = 0;
	private double setpoint = 0;

	// TODO: Find these values
	private static final double P = 0;
	private static final double I = 0;
	private static final double D = 0;

	/*
	 * setpoint is the distance needed to travel by
	 */
	public RightDrive(double setpoint) {
		super("RightDrive", P, I, D);
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);

		this.getPIDController().setOutputRange(-MAX_SPEED, MAX_SPEED);
		getPIDController().disable();
		this.setpoint = setpoint;
		startPoint = Robot.driveTrain.getRightEncoderDistance();

		setInterruptible(true);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
    	Robot.driveTrain.resetEncoders();

		setSetpoint(setpoint);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.driveTrain.getRightEncoderDistance() - startPoint) <= SETPOINT_TOLERANCE;
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
		// TODO: add debug info here
		end();
	}

	public double getSpeed(){
		return speed;
	}

	public PIDController getPID(){
		return this.getPIDController();
	}


	protected double returnPIDInput() {
		return Robot.driveTrain.getLeftEncoderDistance();
	}

	protected void usePIDOutput(double output) {
		speed = output;
	}
}
