package frc.robot.data;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Data {

	public static NetworkTableEntry arcadeDriveMoveEntry;
	public static NetworkTableEntry arcadeDriveRotateEntry;

	public static NetworkTableEntry leftDrivePEntry;
	public static NetworkTableEntry leftDriveIEntry;
	public static NetworkTableEntry leftDriveDEntry;
	public static NetworkTableEntry leftEncoderDistanceEntry;

	public static NetworkTableEntry rightDrivePEntry;
	public static NetworkTableEntry rightDriveIEntry;
	public static NetworkTableEntry rightDriveDEntry;
	public static NetworkTableEntry rightEncoderDistanceEntry;

	public static NetworkTableEntry turnPEntry;
	public static NetworkTableEntry turnIEntry;
	public static NetworkTableEntry turnDEntry;

	public static NetworkTableEntry dataAngleEntry;
	public static NetworkTableEntry dataYawEntry;
	public static NetworkTableEntry dataAccelXEntry;
	public static NetworkTableEntry dataAccelYEntry;
	public static NetworkTableEntry dataAccelZEntry;
	public static NetworkTableEntry hatchReleasedEntry;
	public static NetworkTableEntry pistonExtendedEntry;

	public Data(NetworkTableInstance inst) {
	
		NetworkTable dashboard = inst.getTable("dashboard");

		arcadeDriveMoveEntry = dashboard.getEntry("arcadeDriveMoveEntry");
		arcadeDriveRotateEntry = dashboard.getEntry("arcadeDriveRotateEntry");

		leftDrivePEntry = dashboard.getEntry("leftDrivePEntry");
		leftDriveIEntry = dashboard.getEntry("leftDriveIEntry");
		leftDriveDEntry = dashboard.getEntry("leftDriveDEntry");
		leftEncoderDistanceEntry = dashboard.getEntry("leftEncoderDistanceEntry");


		rightDrivePEntry = dashboard.getEntry("rightDrivePEntry");
		rightDriveIEntry = dashboard.getEntry("rightDriveIEntry");
		rightDriveDEntry = dashboard.getEntry("rightDriveDEntry");
		rightEncoderDistanceEntry = dashboard.getEntry("rightEncoderDistanceEntry");

		turnPEntry = dashboard.getEntry("turnPEntry");
		turnIEntry = dashboard.getEntry("turnIEntry");
		turnDEntry = dashboard.getEntry("turnDEntry");

		dataAngleEntry = dashboard.getEntry("dataAngleEntry");
		dataYawEntry = dashboard.getEntry("dataYawEntry");
		dataAccelXEntry = dashboard.getEntry("dataAccelXEntry");
		dataAccelYEntry = dashboard.getEntry("dataAccelYEntry");
		dataAccelZEntry = dashboard.getEntry("dataAccelZEntry");
		hatchReleasedEntry = dashboard.getEntry("hatchReleasedEntry");
		pistonExtendedEntry = dashboard.getEntry("pistonExtendedEntry");
	}
}
