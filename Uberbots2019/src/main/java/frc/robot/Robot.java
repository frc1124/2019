/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.						*/
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.															   */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Compressor;

import frc.robot.subsystems.Drive;
import frc.robot.vision.Camera;
import frc.robot.data.Data;
import frc.robot.data.NTInfo;
import frc.robot.OI;
import frc.robot.subsystems.HatchMechanism;
import frc.robot.subsystems.SuctionCup;
import frc.robot.subsystems.PIDArm;
import frc.robot.subsystems.PIDElevator;
import frc.robot.subsystems.Elevator;

import frc.robot.commands.ElevatorUp;
import frc.robot.commands.PistonExtend;

import edu.wpi.first.networktables.NetworkTableInstance;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

	private static NetworkTableInstance inst;
	
	public static Data ntData;
	public static NTInfo ntInfo;

	public static OI oi;

	public static HatchMechanism hatchMechanism;
	public static SuctionCup suctionCup;
	public static PIDArm arm;
	public static Drive driveTrain;
	public static Camera driveCamera;
	public static Elevator elevator;
	public static Compressor c;

	private boolean toggleCompressor = true;

	@Override
	public void robotInit() {

		inst = NetworkTableInstance.getDefault();
		ntData = new Data(inst);
		ntInfo = new NTInfo(inst);

		driveTrain = new Drive();
		//driveCamera = new Camera("Drive");
		hatchMechanism = new HatchMechanism();
		suctionCup = new SuctionCup();
		arm = new PIDArm();
		//elevator = new Elevator();
		c = new Compressor(RobotMap.COMPRESSOR_ID);

		oi = new OI(); //instantiate this last
	
		c.setClosedLoopControl(true);
	}

	@Override
	public void robotPeriodic() {
		allPeriodic();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// PistonExtend p = new PistonExtend();
		// Scheduler.getInstance().add(p);
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// PistonExtend p = new PistonExtend();
		// ElevatorUp e = new ElevatorUp();
		// Scheduler.getInstance().add(p);
		// Scheduler.getInstance().add(e);
		
	}

	@Override
	public void teleopPeriodic() {
		allPeriodic();
		//System.out.println(elevator.log());
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit(){
	}

	public void allPeriodic() {
		ntInfo.update();
	}

	public void toggleCompressor(){
		this.toggleCompressor = !toggleCompressor;
		c.setClosedLoopControl(toggleCompressor);
	}
}
