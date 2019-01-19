package frc.robot.data;

import frc.robot.RobotMap;
import frc.robot.data.Data;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NTInfo {
	public Data d;
	public PowerDistributionPanel pdp;
	public Compressor compressor;
	public NTInfo(NetworkTableInstance inst) {
		d = new Data(inst);
		pdp = new PowerDistributionPanel(RobotMap.PDP_ID);
		compressor = new Compressor(RobotMap.COMPRESSOR_ID);
	}
	public void update() {
		d.getBatteryEntry().setDouble(pdp.getVoltage());
		d.getPressureEntry().setBoolean(compressor.getPressureSwitchValue());
	}
	
}
