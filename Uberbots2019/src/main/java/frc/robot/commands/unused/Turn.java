package frc.robot.commands.unused;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Turn extends Command {
	private double TOLERANCE = 0.2;

	private double THROTTLE = 0.75;

	private double setPoint;

	/*
	 * @param setPoint - value in degrees between -179 and 180
	 * */
	public Turn(double setPoint){
		this.setPoint = setPoint;
		requires(Robot.driveTrain);
		setInterruptible(true);
	}

	public boolean isFinished(){
		return Math.abs(Robot.driveTrain.getYaw() - setPoint) <= TOLERANCE;
	}

	@Override
	protected void execute() {
		Robot.driveTrain.drive(0, setPoint >= 180 ? THROTTLE : -THROTTLE);
	}

}
