package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;

public class ElevatorDown extends Command {
	// Find setPoint
	//private double setPoint = 0;
	//private final double TOLERANCE = 0.1;
	//private  long startTime = System.currentTimeMillis();

	public ElevatorDown(){
		//super("ElevatorDown", RobotMap.ELEVATOR_P, RobotMap.ELEVATOR_I, RobotMap.ELEVATOR_D);
		requires(Robot.elevator);

		setInterruptible(true);
	}

	public boolean isFinished(){
		//return Math.abs(Robot.elevator.getEncoderDistance() - setPoint) <= TOLLERANCE;
		return !OI.getJoystick().getRawButton(OI.X_BUTTON);
	}

	@Override
	public void end() {
		Robot.elevator.stop();
	}

	@Override
	public void interrupted() {
		Robot.elevator.stop();
	}
	@Override
	protected void execute() {
		Robot.elevator.moveUp(false);
	}
	
	/*
	public double returnPIDInput(){
		return Robot.elevator.getEncoderDistance();
	}
	public void usePIDOutput(double output) {
		Robot.elevator.getPIDController().pidWrite(output);
	}*/
}
