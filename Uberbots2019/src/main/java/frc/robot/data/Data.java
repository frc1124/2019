package frc.robot.data;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Data {

	public NetworkTableEntry arcadeDriveMoveEntry;
	public NetworkTableEntry arcadeDriveRotateEntry;

	public NetworkTableEntry leftDrivePEntry;
	public NetworkTableEntry leftDriveIEntry;
	public NetworkTableEntry leftDriveDEntry;
	public NetworkTableEntry leftEncoderDistanceEntry;

	public NetworkTableEntry rightDrivePEntry;
	public NetworkTableEntry rightDriveIEntry;
	public NetworkTableEntry rightDriveDEntry;
	public NetworkTableEntry rightEncoderDistanceEntry;

	public NetworkTableEntry turnPEntry;
	public NetworkTableEntry turnIEntry;
	public NetworkTableEntry turnDEntry;

	public NetworkTableEntry dataAngleEntry;
	public NetworkTableEntry dataYawEntry;
	public NetworkTableEntry dataAccelXEntry;
	public NetworkTableEntry dataAccelYEntry;
	public NetworkTableEntry dataAccelZEntry;
	public NetworkTableEntry hatchReleasedEntry;
	public NetworkTableEntry pistonExtendedEntry;

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

	public NetworkTableEntry getArcadeDriveMoveEntry() {
		return arcadeDriveMoveEntry;
	}

	public void setArcadeDriveMoveEntry(NetworkTableEntry arcadeDriveMoveEntry) {
		this.arcadeDriveMoveEntry = arcadeDriveMoveEntry;
	}

	public NetworkTableEntry getArcadeDriveRotateEntry() {
		return arcadeDriveRotateEntry;
	}

	public void setArcadeDriveRotateEntry(NetworkTableEntry arcadeDriveRotateEntry) {
		this.arcadeDriveRotateEntry = arcadeDriveRotateEntry;
	}

	public NetworkTableEntry getLeftDrivePEntry() {
		return leftDrivePEntry;
	}

	public void setLeftDrivePEntry(NetworkTableEntry leftDrivePEntry) {
		this.leftDrivePEntry = leftDrivePEntry;
	}

	public NetworkTableEntry getLeftDriveIEntry() {
		return leftDriveIEntry;
	}

	public void setLeftDriveIEntry(NetworkTableEntry leftDriveIEntry) {
		this.leftDriveIEntry = leftDriveIEntry;
	}

	public NetworkTableEntry getLeftDriveDEntry() {
		return leftDriveDEntry;
	}

	public void setLeftDriveDEntry(NetworkTableEntry leftDriveDEntry) {
		this.leftDriveDEntry = leftDriveDEntry;
	}

	public NetworkTableEntry getLeftEncoderDistanceEntry() {
		return leftEncoderDistanceEntry;
	}

	public void setLeftEncoderDistanceEntry(NetworkTableEntry leftEncoderDistanceEntry) {
		this.leftEncoderDistanceEntry = leftEncoderDistanceEntry;
	}

	public NetworkTableEntry getRightDrivePEntry() {
		return rightDrivePEntry;
	}

	public void setRightDrivePEntry(NetworkTableEntry rightDrivePEntry) {
		this.rightDrivePEntry = rightDrivePEntry;
	}

	public NetworkTableEntry getRightDriveIEntry() {
		return rightDriveIEntry;
	}

	public void setRightDriveIEntry(NetworkTableEntry rightDriveIEntry) {
		this.rightDriveIEntry = rightDriveIEntry;
	}

	public NetworkTableEntry getRightDriveDEntry() {
		return rightDriveDEntry;
	}

	public void setRightDriveDEntry(NetworkTableEntry rightDriveDEntry) {
		this.rightDriveDEntry = rightDriveDEntry;
	}

	public NetworkTableEntry getRightEncoderDistanceEntry() {
		return rightEncoderDistanceEntry;
	}

	public void setRightEncoderDistanceEntry(NetworkTableEntry rightEncoderDistanceEntry) {
		this.rightEncoderDistanceEntry = rightEncoderDistanceEntry;
	}

	public NetworkTableEntry getTurnPEntry() {
		return turnPEntry;
	}

	public void setTurnPEntry(NetworkTableEntry turnPEntry) {
		this.turnPEntry = turnPEntry;
	}

	public NetworkTableEntry getTurnIEntry() {
		return turnIEntry;
	}

	public void setTurnIEntry(NetworkTableEntry turnIEntry) {
		this.turnIEntry = turnIEntry;
	}

	public NetworkTableEntry getTurnDEntry() {
		return turnDEntry;
	}

	public void setTurnDEntry(NetworkTableEntry turnDEntry) {
		this.turnDEntry = turnDEntry;
	}

	public NetworkTableEntry getDataAngleEntry() {
		return dataAngleEntry;
	}

	public void setDataAngleEntry(NetworkTableEntry dataAngleEntry) {
		this.dataAngleEntry = dataAngleEntry;
	}

	public NetworkTableEntry getDataYawEntry() {
		return dataYawEntry;
	}

	public void setDataYawEntry(NetworkTableEntry dataYawEntry) {
		this.dataYawEntry = dataYawEntry;
	}

	public NetworkTableEntry getDataAccelXEntry() {
		return dataAccelXEntry;
	}

	public void setDataAccelXEntry(NetworkTableEntry dataAccelXEntry) {
		this.dataAccelXEntry = dataAccelXEntry;
	}

	public NetworkTableEntry getDataAccelYEntry() {
		return dataAccelYEntry;
	}

	public void setDataAccelYEntry(NetworkTableEntry dataAccelYEntry) {
		this.dataAccelYEntry = dataAccelYEntry;
	}

	public NetworkTableEntry getDataAccelZEntry() {
		return dataAccelZEntry;
	}

	public void setDataAccelZEntry(NetworkTableEntry dataAccelZEntry) {
		this.dataAccelZEntry = dataAccelZEntry;
	}

	public NetworkTableEntry getHatchReleasedEntry() {
		return hatchReleasedEntry;
	}

	public void setHatchReleasedEntry(NetworkTableEntry hatchReleasedEntry) {
		this.hatchReleasedEntry = hatchReleasedEntry;
	}

	public NetworkTableEntry getPistonExtendedEntry() {
		return pistonExtendedEntry;
	}

	public void setPistonExtendedEntry(NetworkTableEntry pistonExtendedEntry) {
		this.pistonExtendedEntry = pistonExtendedEntry;
	}
}
