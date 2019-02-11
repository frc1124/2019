package frc.robot.vision;

import frc.robot.GripPipeline;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera; 

import org.opencv.core.Mat;

/**
 * The subsystem that manages camera streams and data processing
 */
public class Camera extends Subsystem {

	protected static CvSink cvSink;

	public static final int CAMERA_RESOLUTION_X = 320;
	public static final int CAMERA_RESOLUTION_Y = 240;

	protected String name;

	public Camera(String name){
		super(name);

		this.name = name;
		
		initCamera(name);
	}
	
	protected void initDefaultCommand() {}
	
	private void initCamera(String name){
		try{
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(CAMERA_RESOLUTION_X, CAMERA_RESOLUTION_Y);
			camera.setFPS(20);
		}catch(Exception e) {
			System.out.println("Failed to initialize Microsoft LifeCam.");
		}

		cvSink = CameraServer.getInstance().getVideo();

		if(name == "Drive"){
			CameraServer.getInstance().putVideo(name, CAMERA_RESOLUTION_X, CAMERA_RESOLUTION_Y);
		}
	}

	public Mat getMat(){
		Mat source = new Mat();
		cvSink.grabFrame(source);
		return source;
	}

	/*
	public int getContourCenter(Mat input)
	{
		this.process(this.getMat());
		double[] r = this.getXRange();
		double xCenter = ((r[0]+r[1])/2);
	}
	*/
}