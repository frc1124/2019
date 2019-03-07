package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class PIDArm extends PIDSubsystem{

	protected WPI_TalonSRX arm;
	// TODO get value
	private final double ANGLE_PER_OHM = 0.72;

	protected SpeedControllerGroup armSC;
	protected AnalogPotentiometer pot;

	protected final double THROTTLE = .25;

	public PIDArm(){
		super("PIDArm",RobotMap.ARM_P,RobotMap.ARM_I,RobotMap.ARM_D,RobotMap.ARM_F);
		
		arm = new WPI_TalonSRX(RobotMap.ARM); //Check device numbers
		armSC = new SpeedControllerGroup(arm);

		arm.setNeutralMode(NeutralMode.Brake);

		pot = new AnalogPotentiometer(RobotMap.POT, 3600, 0);
		// Set tolerance
		setAbsoluteTolerance(0.1);
		getPIDController().setContinuous(false);
	}

	public void move(double y){
		armSC.set(y * THROTTLE);
	}

	public void stop() {
		armSC.stopMotor();
	}

	public double potGet() {
		return pot.get();
	}

	public double getAngle() {
		return (pot.get() / ANGLE_PER_OHM) - 40; // assuming 0 degrees on pot is at pickup position
	}

	@Override
	public void initDefaultCommand(){
	}

	public void usePIDOutput(double output) {
		arm.pidWrite(output);
	}

	public double returnPIDInput() {
		return pot.get();
	}

	public void run(double p) {
		this.armSC.set(p);
	}
}
