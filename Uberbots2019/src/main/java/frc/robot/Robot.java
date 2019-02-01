/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.						*/
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.															   */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import frc.robot.subsystems.Drive;
import frc.robot.vision.Camera;
import frc.robot.data.Data;
import frc.robot.data.NTInfo;
import frc.robot.OI;
import frc.robot.subsystems.HatchMechanism;
import frc.robot.subsystems.SuctionCup;
import frc.robot.commands.PIDTuner;
import frc.robot.subsystems.PIDDrive;

import edu.wpi.first.networktables.NetworkTableInstance;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

	NetworkTableInstance inst;
	
	public static Data ntData;
	public static NTInfo ntInfo;
	public static PIDDrive driveTrain;
	public static Camera driveCamera;

	public static OI oi;

	public static HatchMechanism hatchMechanism;

	public static SuctionCup suctionCup;

	public static PIDTuner pidTuner;

	@Override
	public void robotInit() {

		inst = NetworkTableInstance.getDefault();
		ntData = new Data(inst);
		ntInfo = new NTInfo(inst);

		driveTrain = new PIDDrive();
		driveCamera = new Camera("Drive");
		suctionCup - new SuctionCup();
		hatchMechanism = new HatchMechanism();

		oi = new OI(); //instantiate this last
	}

	@Override
	public void robotPeriodic() {
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
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		allPeriodic();
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit(){
		pidTuner = new PIDTuner(4);
		pidTuner.start();
	}

	public void allPeriodic() {
		ntInfo.update();
	}
}
