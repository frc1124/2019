package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class PIDElevator extends PIDSubsystem{

	// TODO: get val
	public double DISTANCE_PER_TICK = Math.PI / 4096;

	protected WPI_TalonSRX shaft1, shaft2;

	protected SpeedControllerGroup shaftSC;

	protected final double THROTTLE = .75;

	protected Encoder enc;

	public PIDElevator(){
        super("PIDElevator");

		// Set up the left side
		shaft1 = new WPI_TalonSRX(RobotMap.ELEVATOR1);
		shaft2 = new WPI_TalonSRX(RobotMap.ELEVATOR2);

		shaftSC = new SpeedControllerGroup(shaft1, shaft2);

		enc = new Encoder(RobotMap.ELEVATOR1, RobotMap.ELEVATOR2);
		enc.setDistancePerPulse(DISTANCE_PER_TICK);
		setNeutralMode(NeutralMode.Brake);

		setAbsoluteTolerance(0.1);
		getPIDController().setContinuous(false);
		
		resetEncoder();
	}

	@Override
	public void initDefaultCommand(){
		//setDefaultCommand(new ElevatorJoystick());
	}

	public void set(double speed) {
		shaftSC.set(speed * THROTTLE);
	}
	
	public void moveUp(boolean up) {
		set(up ? 1 : -1);
	}

	public void stop(){
		shaftSC.stopMotor();
	}

	public void setNeutralMode(NeutralMode mode) {
		shaft1.setNeutralMode(mode);
		shaft2.setNeutralMode(mode);
	}
	
	// manual drive

	public void shaftManual(double speed) {
		shaftSC.set(speed);
	}

	// encoder methods
	
	public double getEncoderDistance(){
		return enc.getDistance();
	}

	public double getEncoderVelocity(){
		return enc.getRate();
	}

	public void resetEncoder(){
		enc.reset();
	}
}
