package frc.robot.commands;

import frc.robot.vision.GripPipeline;
import frc.robot.commands.Turn;

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
		requires(Robot.driveFoward);
		requires(Robot.driveTrain);
		filter = new GripPipeline();
		//turn = new Turn(); 
		this.setInterruptible(false);
	}

	protected void end() {
		this.done = true;
	}

	protected void initialize() {
		Mat img = Robot.driveFoward.getMat();
		this.filter.process(img);
		range = filter.getXRange();
		lx = range[0];
		hx = range[1];
		mx = (lx + hx) / 2;
		//mx = Camera.getContourCenter(img)
		Robot.ntInfo.update();
		difference = mx - (Camera.CAMERA_RESOLUTION_X / 2);
		
	}

	protected void execute() {

		Mat img = Robot.driveFoward.getMat();
		this.filter.process(img);
		range = filter.getXRange();
		lx = range[0];
		hx = range[1];
		mx = (lx + hx) / 2;
		//mx = Camera.getContourCenter(img)
		Robot.ntData.targetCenterEntry.setDouble(mx);
		difference = mx - (Camera.CAMERA_RESOLUTION_X / 2);
		/*
		while ((mx <= 310)||(mx >= 330))
		{
			mxOld = mx;
			Robot.turn(1);
			Mat img = Robot.driveCamera.getMat();
			this.filter.process(img);
			range = filter.getXRange();
			lx = range[0];
			hx = range[1];
			mx = (lx + hx) / 2;
			if (mx > mxOld)
			{ Robot.turn(1);}
			if (mx<mxOld)
			{ Robot.turn(-2);}
			else
			{ break;}
		}
		*/
	}

	public void interrupted() {
		this.end();
	}

	@Override
	protected boolean isFinished() {
		return done;
	}

}