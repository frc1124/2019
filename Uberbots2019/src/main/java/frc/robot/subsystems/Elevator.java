package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class Elevator extends Subsystem{
	protected WPI_TalonSRX shaft, slave;
	protected SpeedControllerGroup shaftSC;

	protected final double THROTTLE = 1;
	public double DISTANCE_PER_TICK = (2/25.4) / 4096; // measuring height at 2mm per round, in inches

	private boolean raiseElevator = true;

	public Elevator(){
        super("Elevator");

		// Set up the left side
		shaft = new WPI_TalonSRX(RobotMap.ELEVATOR1);
		slave = new WPI_TalonSRX(RobotMap.ELEVATOR2);
		
		shaftSC = new SpeedControllerGroup(shaft, slave);
		System.out.println("Init");
	}

	@Override
	public void initDefaultCommand(){}

	public void stop(){
		shaftSC.stopMotor();
	}

	public void setNeutralMode(NeutralMode mode) {
		shaft.setNeutralMode(mode);
		slave.setNeutralMode(mode);
	}
	
	// manual drive

	public void shaftManual(double speed) {
		shaftSC.set(speed);
	}

	public double getPosition() {
		return shaft.getSensorCollection().getQuadraturePosition() * DISTANCE_PER_TICK;
	}

	public boolean getRaiseElevator(){
		return raiseElevator;
	}

	public void set(double speed) {
		shaftSC.set(speed * THROTTLE);
	}
	
	public void moveUp(boolean up) {
		set(up ? 1 : -1);
	}

	public String log(){
		return "shaftSC - " + shaftSC.get() + " - shaft - " + shaft.get() + " - Start Time - " + System.currentTimeMillis();
	}
}
