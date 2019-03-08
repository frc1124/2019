package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.Robot;

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
	private final double ARM_LENGTH = 31.25;

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
/*
		// Make sure the arm does not crash into other mechanisms
		double angle = getAngle();
		double elevatorHeight = Robot.elevator.getPosition();
		double xSlope = Math.abs(Math.cos(angle));
		double ySlope = Math.sin(angle);

		// Avoid crashing into front and back
		double collisionX = 0;
		double collisionY = 0;
// TODO: Measure the actual collision points (top inside distance from lowest elevator height)
		if (angle > 90) {
			collisionX = 12;
			collisionY = 14;
		} else {
			collisionX = 6.5;
			collisionY = 6.5;
		}

		// Will it collide?
		double y = elevatorHeight + ySlope * ARM_LENGTH;
		if (y < collisionY) {
			// Is the x slope great enough to avoid collision?
			double armX = xSlope * ARM_LENGTH;
			if (armX >= collisionX) {
				// Collided; set speed to zero
				arm.pidWrite(0);
				return;
			}
		}
*/
		arm.pidWrite(output);
	}

	public double returnPIDInput() {
		return pot.get();
	}

	public void run(double p) {
		this.armSC.set(p);
	}

	public void setAngle(double angle) {
		this.getPIDController().setSetpoint((angle + 40) * ANGLE_PER_OHM);
	}

	public void setVelocity(double v) {
		arm.set(ControlMode.Velocity,v);
	}
}
