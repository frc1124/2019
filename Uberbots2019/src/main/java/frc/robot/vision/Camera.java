package frc.robot.vision;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera; 

import org.opencv.core.Mat;

/**
 * The subsystem that manages camera streams and data processing
 */
public class Camera extends Subsystem {

	protected static CvSink cvSink;

	protected final int CAMERA_RESOLUTION_X = 640;
	protected final int CAMERA_RESOLUTION_Y = 480;

	public Camera(UsbCamera camera, String name){
		super("camera");
		
		initCamera(camera, name);
	}
	
	protected void initDefaultCommand() {}
	
	private void initCamera(UsbCamera camera, String name){
		try{
			camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(CAMERA_RESOLUTION_X, CAMERA_RESOLUTION_Y);
			camera.setFPS(20);
		}catch(Exception e) {
			System.out.println("Failed to initialize Microsoft LifeCam.");
		}

		cvSink = CameraServer.getInstance().getVideo();
		CameraServer.getInstance().putVideo(name, CAMERA_RESOLUTION_X, CAMERA_RESOLUTION_Y);
	}

	public Mat getMat(){
		Mat source = new Mat();
		cvSink.grabFrame(source);
		return source;
	}
}