package frc.robot.data;

import java.util.HashMap;
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

	public NetworkTableEntry batteryEntry;
	public NetworkTableEntry pressureEntry;

	public NetworkTableEntry logEntry;

	public NetworkTableEntry targetCenterEntry;
	public NetworkTableEntry targetCenterYEntry;

	public NetworkTableEntry controlMode;

	private NetworkTable contoursReport;
	public HashMap<String,Double> visionData = new HashMap<String,Double>();

	public Data(NetworkTableInstance inst) {
	
		NetworkTable dashboard = inst.getTable("dash");

		leftEncoderDistanceEntry = dashboard.getEntry("leftEncoderDistanceEntry");

		arcadeDriveMoveEntry = dashboard.getEntry("arcadeDriveMoveEntry");
		arcadeDriveRotateEntry = dashboard.getEntry("arcadeDriveRotateEntry");

		leftDrivePEntry = dashboard.getEntry("leftDrivePEntry");
		leftDriveIEntry = dashboard.getEntry("leftDriveIEntry");
		leftDriveDEntry = dashboard.getEntry("leftDriveDEntry");
		

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

		batteryEntry = dashboard.getEntry("batteryEntry");
		pressureEntry = dashboard.getEntry("pressureEntry");

		logEntry = dashboard.getEntry("logEntry");

		//targetCenterXEntry = dashboard.getEntry("targetCenterXEntry");
		targetCenterEntry = dashboard.getEntry("targetCenterEntry");

		controlMode = dashboard.getEntry("controlMode");

		contoursReport = inst.getTable("GRIP/myContoursReport");
	}
	
	/**
	 * Get arcadeDriveMoveEntry.
	 *
	 * @return arcadeDriveMoveEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getArcadeDriveMoveEntry()
	{
	    return arcadeDriveMoveEntry;
	}
	
	/**
	 * Set arcadeDriveMoveEntry.
	 *
	 * @param arcadeDriveMoveEntry the value to set.
	 */
	public void setArcadeDriveMoveEntry(NetworkTableEntry arcadeDriveMoveEntry)
	{
	    this.arcadeDriveMoveEntry = arcadeDriveMoveEntry;
	}
	
	/**
	 * Get arcadeDriveRotateEntry.
	 *
	 * @return arcadeDriveRotateEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getArcadeDriveRotateEntry()
	{
	    return arcadeDriveRotateEntry;
	}
	
	/**
	 * Set arcadeDriveRotateEntry.
	 *
	 * @param arcadeDriveRotateEntry the value to set.
	 */
	public void setArcadeDriveRotateEntry(NetworkTableEntry arcadeDriveRotateEntry)
	{
	    this.arcadeDriveRotateEntry = arcadeDriveRotateEntry;
	}
	
	/**
	 * Get leftDrivePEntry.
	 *
	 * @return leftDrivePEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getLeftDrivePEntry()
	{
	    return leftDrivePEntry;
	}
	
	/**
	 * Set leftDrivePEntry.
	 *
	 * @param leftDrivePEntry the value to set.
	 */
	public void setLeftDrivePEntry(NetworkTableEntry leftDrivePEntry)
	{
	    this.leftDrivePEntry = leftDrivePEntry;
	}
	
	/**
	 * Get leftDriveIEntry.
	 *
	 * @return leftDriveIEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getLeftDriveIEntry()
	{
	    return leftDriveIEntry;
	}
	
	/**
	 * Set leftDriveIEntry.
	 *
	 * @param leftDriveIEntry the value to set.
	 */
	public void setLeftDriveIEntry(NetworkTableEntry leftDriveIEntry)
	{
	    this.leftDriveIEntry = leftDriveIEntry;
	}
	
	/**
	 * Get leftDriveDEntry.
	 *
	 * @return leftDriveDEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getLeftDriveDEntry()
	{
	    return leftDriveDEntry;
	}
	
	/**
	 * Set leftDriveDEntry.
	 *
	 * @param leftDriveDEntry the value to set.
	 */
	public void setLeftDriveDEntry(NetworkTableEntry leftDriveDEntry)
	{
	    this.leftDriveDEntry = leftDriveDEntry;
	}
	
	/**
	 * Get leftEncoderDistanceEntry.
	 *
	 * @return leftEncoderDistanceEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getLeftEncoderDistanceEntry()
	{
	    return leftEncoderDistanceEntry;
	}
	
	/**
	 * Set leftEncoderDistanceEntry.
	 *
	 * @param leftEncoderDistanceEntry the value to set.
	 */
	public void setLeftEncoderDistanceEntry(NetworkTableEntry leftEncoderDistanceEntry)
	{
	    this.leftEncoderDistanceEntry = leftEncoderDistanceEntry;
	}
	
	/**
	 * Get rightDrivePEntry.
	 *
	 * @return rightDrivePEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getRightDrivePEntry()
	{
	    return rightDrivePEntry;
	}
	
	/**
	 * Set rightDrivePEntry.
	 *
	 * @param rightDrivePEntry the value to set.
	 */
	public void setRightDrivePEntry(NetworkTableEntry rightDrivePEntry)
	{
	    this.rightDrivePEntry = rightDrivePEntry;
	}
	
	/**
	 * Get rightDriveIEntry.
	 *
	 * @return rightDriveIEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getRightDriveIEntry()
	{
	    return rightDriveIEntry;
	}
	
	/**
	 * Set rightDriveIEntry.
	 *
	 * @param rightDriveIEntry the value to set.
	 */
	public void setRightDriveIEntry(NetworkTableEntry rightDriveIEntry)
	{
	    this.rightDriveIEntry = rightDriveIEntry;
	}
	
	/**
	 * Get rightDriveDEntry.
	 *
	 * @return rightDriveDEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getRightDriveDEntry()
	{
	    return rightDriveDEntry;
	}
	
	/**
	 * Set rightDriveDEntry.
	 *
	 * @param rightDriveDEntry the value to set.
	 */
	public void setRightDriveDEntry(NetworkTableEntry rightDriveDEntry)
	{
	    this.rightDriveDEntry = rightDriveDEntry;
	}
	
	/**
	 * Get rightEncoderDistanceEntry.
	 *
	 * @return rightEncoderDistanceEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getRightEncoderDistanceEntry()
	{
	    return rightEncoderDistanceEntry;
	}
	
	/**
	 * Set rightEncoderDistanceEntry.
	 *
	 * @param rightEncoderDistanceEntry the value to set.
	 */
	public void setRightEncoderDistanceEntry(NetworkTableEntry rightEncoderDistanceEntry)
	{
	    this.rightEncoderDistanceEntry = rightEncoderDistanceEntry;
	}
	
	/**
	 * Get turnPEntry.
	 *
	 * @return turnPEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getTurnPEntry()
	{
	    return turnPEntry;
	}
	
	/**
	 * Set turnPEntry.
	 *
	 * @param turnPEntry the value to set.
	 */
	public void setTurnPEntry(NetworkTableEntry turnPEntry)
	{
	    this.turnPEntry = turnPEntry;
	}
	
	/**
	 * Get turnIEntry.
	 *
	 * @return turnIEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getTurnIEntry()
	{
	    return turnIEntry;
	}
	
	/**
	 * Set turnIEntry.
	 *
	 * @param turnIEntry the value to set.
	 */
	public void setTurnIEntry(NetworkTableEntry turnIEntry)
	{
	    this.turnIEntry = turnIEntry;
	}
	
	/**
	 * Get turnDEntry.
	 *
	 * @return turnDEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getTurnDEntry()
	{
	    return turnDEntry;
	}
	
	/**
	 * Set turnDEntry.
	 *
	 * @param turnDEntry the value to set.
	 */
	public void setTurnDEntry(NetworkTableEntry turnDEntry)
	{
	    this.turnDEntry = turnDEntry;
	}
	
	/**
	 * Get dataAngleEntry.
	 *
	 * @return dataAngleEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getDataAngleEntry()
	{
	    return dataAngleEntry;
	}
	
	/**
	 * Set dataAngleEntry.
	 *
	 * @param dataAngleEntry the value to set.
	 */
	public void setDataAngleEntry(NetworkTableEntry dataAngleEntry)
	{
	    this.dataAngleEntry = dataAngleEntry;
	}
	
	/**
	 * Get dataYawEntry.
	 *
	 * @return dataYawEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getDataYawEntry()
	{
	    return dataYawEntry;
	}
	
	/**
	 * Set dataYawEntry.
	 *
	 * @param dataYawEntry the value to set.
	 */
	public void setDataYawEntry(NetworkTableEntry dataYawEntry)
	{
	    this.dataYawEntry = dataYawEntry;
	}
	
	/**
	 * Get dataAccelXEntry.
	 *
	 * @return dataAccelXEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getDataAccelXEntry()
	{
	    return dataAccelXEntry;
	}
	
	/**
	 * Set dataAccelXEntry.
	 *
	 * @param dataAccelXEntry the value to set.
	 */
	public void setDataAccelXEntry(NetworkTableEntry dataAccelXEntry)
	{
	    this.dataAccelXEntry = dataAccelXEntry;
	}
	
	/**
	 * Get dataAccelYEntry.
	 *
	 * @return dataAccelYEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getDataAccelYEntry()
	{
	    return dataAccelYEntry;
	}
	
	/**
	 * Set dataAccelYEntry.
	 *
	 * @param dataAccelYEntry the value to set.
	 */
	public void setDataAccelYEntry(NetworkTableEntry dataAccelYEntry)
	{
	    this.dataAccelYEntry = dataAccelYEntry;
	}
	
	/**
	 * Get dataAccelZEntry.
	 *
	 * @return dataAccelZEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getDataAccelZEntry()
	{
	    return dataAccelZEntry;
	}
	
	/**
	 * Set dataAccelZEntry.
	 *
	 * @param dataAccelZEntry the value to set.
	 */
	public void setDataAccelZEntry(NetworkTableEntry dataAccelZEntry)
	{
	    this.dataAccelZEntry = dataAccelZEntry;
	}
	
	/**
	 * Get hatchReleasedEntry.
	 *
	 * @return hatchReleasedEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getHatchReleasedEntry()
	{
	    return hatchReleasedEntry;
	}
	
	/**
	 * Set hatchReleasedEntry.
	 *
	 * @param hatchReleasedEntry the value to set.
	 */
	public void setHatchReleasedEntry(NetworkTableEntry hatchReleasedEntry)
	{
	    this.hatchReleasedEntry = hatchReleasedEntry;
	}
	
	/**
	 * Get pistonExtendedEntry.
	 *
	 * @return pistonExtendedEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getPistonExtendedEntry()
	{
	    return pistonExtendedEntry;
	}
	
	/**
	 * Set pistonExtendedEntry.
	 *
	 * @param pistonExtendedEntry the value to set.
	 */
	public void setPistonExtendedEntry(NetworkTableEntry pistonExtendedEntry)
	{
	    this.pistonExtendedEntry = pistonExtendedEntry;
	}
	
	/**
	 * Get batteryEntry.
	 *
	 * @return batteryEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getBatteryEntry()
	{
	    return batteryEntry;
	}
	
	/**
	 * Set batteryEntry.
	 *
	 * @param batteryEntry the value to set.
	 */
	public void setBatteryEntry(NetworkTableEntry batteryEntry)
	{
	    this.batteryEntry = batteryEntry;
	}
	
	/**
	 * Get pressureEntry.
	 *
	 * @return pressureEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getPressureEntry()
	{
	    return pressureEntry;
	}
	
	/**
	 * Set pressureEntry.
	 *
	 * @param pressureEntry the value to set.
	 */
	public void setPressureEntry(NetworkTableEntry pressureEntry)
	{
	    this.pressureEntry = pressureEntry;
	}
	
	/**
	 * Get logEntry.
	 *
	 * @return logEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getLogEntry()
	{
	    return logEntry;
	}
	
	/**
	 * Set logEntry.
	 *
	 * @param logEntry the value to set.
	 */
	public void setLogEntry(NetworkTableEntry logEntry)
	{
	    this.logEntry = logEntry;
	}
	
	/**
	 * Get targetCenterXEntry.
	 *
	 * @return targetCenterXEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getTargetCenterEntry()
	{
	    return targetCenterEntry;
	}
	
	/**
	 * Set targetCenterXEntry.
	 *
	 * @param targetCenterEntry the value to set.
	 */
	public void setTargetCenterEntry(NetworkTableEntry targetCenterEntry)
	{
	    this.targetCenterEntry = targetCenterEntry;
	}
	
	/**
	 * Get targetCenterYEntry.
	 *
	 * @return targetCenterYEntry as NetworkTableEntry.
	 */
	public NetworkTableEntry getTargetCenterYEntry()
	{
	    return targetCenterYEntry;
	}
	
	/**
	 * Set targetCenterYEntry.
	 *
	 * @param targetCenterYEntry the value to set.
	 */
	public void setTargetCenterYEntry(NetworkTableEntry targetCenterYEntry)
	{
	    this.targetCenterYEntry = targetCenterYEntry;
	}

	/**
	 * Get controlMode.
	 *
	 * @return controlMode as NetworkTableEntry.
	 */
	public NetworkTableEntry getControlMode()
	{
	    return controlMode;
	}
	
	/**
	 * Set controlMode.
	 *
	 * @param controlMode the value to set.
	 */
	public void setControlMode(NetworkTableEntry controlMode)
	{
	    this.controlMode = controlMode;
	}

	/**
	 * Get visionData.
	 *
	 * @return visionData as NetworkTableEntry.
	 */
	public Double getVisionData(String name)
	{
		// Update from NetworkTables
		for (String n : contoursReport.getKeys()) {
			this.visionData.put(n,contoursReport.getEntry(n).getDouble(-1.0));
		}
		return this.visionData.get(name);
	}
	
	/**
	 * Set visionData.
	 *
	 * @param visionData the value to set.
	 */
	public void setVisionData(String name,Double value)
	{
		this.visionData.put(name,value);
	}
}
