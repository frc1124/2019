package frc.robot.vision;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.cscore.UsbCamera; 


/**
 * The subsystem that manages camera streams and data processing
 */
public class Camera extends Subsystem {

 	public static final int CAMERA_RESOLUTION_X = 320;
	public static final int CAMERA_RESOLUTION_Y = 240;

	public static final int CAMERA_FORWARD = 0;
	public static final int CAMERA_BACKWARD = 1;

	private UsbCamera forward, backward, current;
	private int currentId;

	public Camera(){
		super("Camera");

		// Configure the cameras
		this.forward = CameraServer.getInstance().startAutomaticCapture(Camera.CAMERA_FORWARD);
		initCamera(this.forward);

		this.backward = CameraServer.getInstance().startAutomaticCapture(Camera.CAMERA_FORWARD);
		initCamera(this.backward);

		// Default the current camera to forward
		setCurrentCamera(Camera.CAMERA_FORWARD);
	}
	
	protected void initDefaultCommand() {}
	
	private void initCamera(UsbCamera camera){
		// Configure the camera
		try{
			camera.setResolution(CAMERA_RESOLUTION_X, CAMERA_RESOLUTION_Y);
			camera.setFPS(12);
		}catch(Exception e) {
			System.out.println("Failed to initialize Microsoft LifeCam: " + camera);
		}
	}

	public void setCurrentCamera(int cameraId) {
		// Set the current variables based on the cameraId
		currentId = cameraId;
		switch (cameraId) {
		case Camera.CAMERA_BACKWARD:
			current = backward;
			break;
		case Camera.CAMERA_FORWARD:
		default:
			current = forward;
			break;
		}

		// Update the CameraServer to stream the correct camera
		CameraServer.getInstance().getServer().setSource(current);
		CameraServer.getInstance().putVideo("camera", CAMERA_RESOLUTION_X, CAMERA_RESOLUTION_Y);
	}

	public int getCurrentCamera() {
		// Return the current cameraId
		return currentId;
	}
}