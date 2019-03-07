package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ElevatorUp extends Command {
	// TODO: Find setPoint
	private double setPoint = 0;
	private final double TOLLERANCE = 0.1;

	private long startTime;

	public ElevatorUp(){
		//super("ElevatorUp", RobotMap.ELEVATOR_P, RobotMap.ELEVATOR_I, RobotMap.ELEVATOR_D);
		requires(Robot.elevator);

		startTime = System.currentTimeMillis();

		setInterruptible(true);
	}

	public boolean isFinished(){
		//return Math.abs(Robot.elevator.getEncoderDistance() - setPoint) <= TOLLERANCE;
		return System.currentTimeMillis() - startTime >= 2000;
	}

	@Override
	protected void execute() {
		Robot.elevator.moveUp(true);
	}
	/*
	public double returnPIDInput(){
		return Robot.elevator.getEncoderDistance();
	}

	public void usePIDOutput(double output) {
		Robot.elevator.getPIDController().pidWrite(output);
	}
	*/
}
