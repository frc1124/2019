package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Arm extends Subsystem{

	// TODO: Change value
	private double ANGLE_PER_TICK = 0;

	private int kTimeoutMs = 20;
	private int kArcadeProfile = 0;

	protected static WPI_TalonSRX arm;

	protected static SpeedControllerGroup armSC;

	private double ANG_OFFSET = 0;

	protected final double THROTTLE = .75;


	public Arm(){
		super("Arm");
		//arm = new WPI_TalonSRX(RobotMap.ARM); //Check device numbers
		
		arm.config_kP(kArcadeProfile,RobotMap.ARM_P);
		arm.config_kI(kArcadeProfile,RobotMap.ARM_I);
		arm.config_kD(kArcadeProfile,RobotMap.ARM_D);
		arm.config_kF(kArcadeProfile,RobotMap.ARM_F);
		arm.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, kTimeoutMs);
		armSC = new SpeedControllerGroup(arm);
	}

	// 0 to 360
	public void move(double y){
		armSC.set(y * THROTTLE);
	}

	public void stop() {
		armSC.stopMotor();
	}

	@Override
	public void initDefaultCommand(){
	
	}

	public void setLeftPosition(double angle) {
		arm.set(ControlMode.Position, angle / ANGLE_PER_TICK);
	}
}


