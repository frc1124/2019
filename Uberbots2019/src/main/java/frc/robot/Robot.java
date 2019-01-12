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
import frc.robot.OI;
import frc.robot.subsystems.HatchMechanism;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static NetworkTableEntry arcadeDriveMoveEntry;
	public static NetworkTableEntry arcadeDriveRotateEntry;

	public static NetworkTableEntry leftDrivePEntry;
	public static NetworkTableEntry leftDriveIEntry;
	public static NetworkTableEntry leftDriveDEntry;

	public static NetworkTableEntry rightDrivePEntry;
	public static NetworkTableEntry rightDriveIEntry;
	public static NetworkTableEntry rightDriveDEntry;

	public static NetworkTableEntry turnPEntry;
	public static NetworkTableEntry turnIEntry;
	public static NetworkTableEntry turnDEntry;

	public static Drive driveTrain;
	public static Camera driveCamera;

	public static OI oi;

	public static HatchMechanism hatchMechanism;

	@Override
	public void robotInit() {

		driveTrain = new Drive();
		driveCamera = new Camera("Drive");
		hatchMechanism = new HatchMechanism();

		oi = new OI(); //instantiate this last

		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		NetworkTable dashboard = inst.getTable("dashboard");

		arcadeDriveMoveEntry = dashboard.getEntry("arcadeDriveMoveEntry");
		arcadeDriveRotateEntry = dashboard.getEntry("arcadeDriveRotateEntry");

		leftDrivePEntry = dashboard.getEntry("dashboard");
		leftDriveIEntry = dashboard.getEntry("dashboard");
		leftDriveDEntry = dashboard.getEntry("dashboard");

		rightDrivePEntry = dashboard.getEntry("dashboard");
		rightDriveIEntry = dashboard.getEntry("dashboard");
		rightDriveDEntry = dashboard.getEntry("dashboard");

		turnPEntry = dashboard.getEntry("dashboard");
		turnIEntry = dashboard.getEntry("dashboard");
		turnDEntry = dashboard.getEntry("dashboard");
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
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
