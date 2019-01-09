package org.usfirst.frc.team1124.robot.subsystems;

import org.usfirst.frc.team1124.robot.Robot;
import org.usfirst.frc.team1124.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The subsystem that manages camera streams and data processing
 */
public class Camera extends Subsystem {

	public Camera(){
		super("camera");
		
		initCamera();
	}
	
	protected void initDefaultCommand() {}
	
	private void initCamera(){
		try{
			Robot.camera = new USBCamera("cam0");
			Robot.camera.openCamera();
			
			Robot.camera.setSize(160, 120);
			
			Robot.camera.setFPS(20);
			
			CameraServer.getInstance().startAutomaticCapture(Robot.camera);
		}catch(Exception e) {
			System.out.println("Failed to initialize Microsoft LifeCam.");
		}
	}
	/** 
	 * Polls the target dimensions from the dashboard.
	 * If they are not present, it returns {-1, -1}.
	 * 
	 * @return An array of { width, height }
	 * */
	public double[] getTargetDimensions(){
		double width = -1;
		double height = -1;
		
		try{
			width = SmartDashboard.getNumber("vision_target_width");
			height = SmartDashboard.getNumber("vision_target_height");
		}catch(Exception e){}
		
		double data[] = {width, height};
		
		return data;
	}
	
	/** 
	 * Polls the target dimensions from the dashboard.
	 * If they are not present, it returns {-1, -1}.
	 * 
	 * @return an array of the {x center of mass, y center of mass}
	 * */
	public double[] getTargetCenterOfMass(){
		double x = -1;
		double y = -1;
		
		try{
			x = SmartDashboard.getNumber("vision_target_x_cm");
			y = SmartDashboard.getNumber("vision_target_y_cm");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		double data[] = {x, y};
		
		return data;
	}
}