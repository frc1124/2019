package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Do NOT put GripPipeline or any other OpenCV on the roboRIO unless you have been 
 * able to carefully tune it to not interfere with actuator control.
 * 
 * Use a co-processor, such as a Raspberry Pi, instead. Read the co-processor's 
 * output from SmartDashboard.
 */

public class TargetVisionTape extends Command {
	private static final double FORWARD_POWER = 0.35;

	private boolean done = false;
	private double cameraCenterX = -1;
	private double cameraWidth = -1;
//	private int tolerance = 10;

	public TargetVisionTape() {
		requires(Robot.driveTrain);
		this.setInterruptible(false);
	}

	protected void initialize() {
		// Make sure we're getting a good read from the co-processor
		double cameraWidth = Robot.ntData.getVisionData("camera_width");
		double x = Robot.ntData.getVisionData("center_x");

		// If no read, abort
		if (cameraCenterX <= 0 || x <= 0) {
			this.done = true;
		} else {
			cameraCenterX = cameraWidth / 2;
		}
	}

	protected void execute() {
		double x = Robot.ntData.getVisionData("centerX");
		double difference = x - cameraCenterX;
		double adjustment = difference / cameraWidth;

		// Drive forward with turn affected by adjustment; negative is left, positive is right
		Robot.driveTrain.drive(FORWARD_POWER, adjustment);
	}

	protected void end() {
		Robot.driveTrain.stop();
		this.done = true;
	}

	public void interrupted() {
		this.end();
	}

	@Override
	protected boolean isFinished() {
		return done;
	}

}