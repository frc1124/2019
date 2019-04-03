package frc.robot.subsystems.unused;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.SPI;

public class PIDElevator extends PIDSubsystem{

	protected WPI_TalonSRX shaft, slave;
	protected SpeedControllerGroup shaftSC;
	protected Encoder enc;

	//	private int TIMEOUT = 500;
	//	private int kTimeoutMs = 20;
	//	private int kArcadeProfile = 0;

	public double DISTANCE_PER_TICK = (2/25.4) / 4096; // reporting height; 2mm per turn adjust for inches
	public static final double THROTTLE = .7775;

	private boolean raiseElevator = true;

	public PIDElevator(){
        super("PIDElevator", RobotMap.ELEVATOR_P, RobotMap.ELEVATOR_I, RobotMap.ELEVATOR_D);

		// Set up the left side
		shaft = new WPI_TalonSRX(RobotMap.ELEVATOR1);
		/*
		shaft.config_kP(kArcadeProfile,RobotMap.ELEVATOR_P);
		shaft.config_kI(kArcadeProfile,RobotMap.ELEVATOR_I);
		shaft.config_kD(kArcadeProfile,RobotMap.ELEVATOR_D);
		shaft.config_kF(kArcadeProfile,RobotMap.ELEVATOR_F);
		shaft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,kTimeoutMs);
		*/
		slave = new WPI_TalonSRX(RobotMap.ELEVATOR2);
		slave.follow(shaft);
		
		//shaft.setInverted(true);

		shaftSC = new SpeedControllerGroup(shaft, slave);

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
		shaft.setNeutralMode(mode);
		slave.setNeutralMode(mode);
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
		shaft.pidWrite(output);
	}

	// TODO: Fix this Method
	public double returnPIDInput() {
		return shaft.getSelectedSensorPosition();
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
		return shaft.getSelectedSensorPosition();
	}

	//PID Stuff taken from elevator
	
    /*
	public void move(double distance) {
		setPosition(distance);
	}
	*/
	/*
	public void setVelocity(double velocity) {
		shaft.set(ControlMode.Velocity, velocity);
	}

	public void setPosition(double distance) {
		shaft.set(ControlMode.Position, distance / DISTANCE_PER_TICK);
	}

	// encoder methods
	
	public double getEncoderDistance(){
		return shaft.getSensorCollection().getQuadraturePosition();
	}
	
	public double getEncoderVelocity(){
		return shaft.getSensorCollection().getQuadratureVelocity();
	}

	public void resetEncoder(){
		shaft.getSensorCollection().setQuadraturePosition(0, TIMEOUT);
	}
	*/
}
