package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class PIDElevator extends PIDSubsystem{

	// TODO: get val
	public double DISTANCE_PER_TICK = (2/25.4) / 4096; // reporting height; 2mm per turn adjust for inches

	protected WPI_TalonSRX shaft1, shaft2;

	protected SpeedControllerGroup shaftSC;

	protected final double THROTTLE = .7775;

	protected Encoder enc;

	private boolean raiseElevator = true;

	public PIDElevator(){
        super("PIDElevator", RobotMap.ELEVATOR_P, RobotMap.ELEVATOR_I, RobotMap.ELEVATOR_D);

		// Set up the left side
		shaft1 = new WPI_TalonSRX(RobotMap.ELEVATOR1);
		shaft2 = new WPI_TalonSRX(RobotMap.ELEVATOR2);
		shaft2.follow(shaft1);
		
		//shaft1.setInverted(true);

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

	public void usePIDOutput(double output) {
		shaft1.pidWrite(output);
	}

	// TODO: Fix this Method
	public double returnPIDInput() {
		return shaft1.getSelectedSensorPosition();
	}

	public boolean getRaiseElevator(){
		return raiseElevator;
	}

	public void toggleRaiseElevator(){
		raiseElevator = !raiseElevator;
	}

	public void setPosition(double pos) {
		this.getPIDController().setSetpoint(pos);
	}

	public double getPosition() {
		return shaft1.getSelectedSensorPosition();
	}
}
