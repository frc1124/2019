package frc.robot.commands;

import frc.robot.vision.GripPipeline;

import org.opencv.core.Mat;
import frc.robot.Robot;
import frc.robot.vision.Camera;
import frc.robot.vision.GripPipeline;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class TargetVisionTape extends Command {
    
	private boolean done = false;

	public static final int CAMERA_EXPOSURE = 3;

	private int tolerance = 10;
	private double buffer = .4;

	private GripPipeline filter = null;
	private int backupMode = 2;
	
	private double[] range;
	private double lx, hx;
	private double mx;
	private double difference;

	public TargetVisionTape() {
		requires(Robot.driveCamera);
		requires(Robot.driveTrain);
		filter = new GripPipeline();
		this.setInterruptible(false);
	}

	protected void end() {
		this.done = true;
	}

	protected void initialize() {
		
		Mat img = Robot.driveCamera.getMat();
		this.filter.process(img);
		range = filter.getXRange();
		lx = range[0];
		hx = range[1];
		mx = (lx + hx) / 2;
		Robot.ntInfo.update();
		difference = mx - (Camera.CAMERA_RESOLUTION_X / 2);
		
	}

	protected void execute() {

		Mat img = Robot.driveCamera.getMat();
		this.filter.process(img);
		range = filter.getXRange();
		lx = range[0];
		hx = range[1];
		mx = (lx + hx) / 2;
		Robot.ntData.targetCenterEntry.setDouble(mx);
		difference = mx - (Camera.CAMERA_RESOLUTION_X / 2);

	}

	
	public void interrupted() {
		this.end();
	}

	@Override
	protected boolean isFinished() {
		return done;
	}

}