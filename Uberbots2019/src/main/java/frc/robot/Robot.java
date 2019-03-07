/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.						*/
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.															   */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Compressor;

import frc.robot.subsystems.Drive;
import frc.robot.vision.Camera;
import frc.robot.data.Data;
import frc.robot.data.NTInfo;
import frc.robot.OI;
import frc.robot.subsystems.HatchMechanism;
import frc.robot.subsystems.SuctionCup;
import frc.robot.subsystems.PIDArm;
import frc.robot.subsystems.PIDElevator;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

import frc.robot.commands.ElevatorUp;
import frc.robot.commands.PistonExtend;

import edu.wpi.first.networktables.NetworkTableInstance;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

	private static NetworkTableInstance inst;
	
	public static Data ntData;
	public static NTInfo ntInfo;

	public static OI oi;

	public static HatchMechanism hatchMechanism;
	public static SuctionCup suctionCup;
	public static PIDArm arm;
	public static Drive driveTrain;
	public static Camera driveCamera;
	public static Compressor c;
	public static PIDElevator elevator;
	public static Elevator manualElevator;
	public static Arm manualArm;

	private boolean toggleCompressor = true;

	public static final int CONTROL_MODE_AUTO = 1;
	public static final int CONTROL_MODE_TELEOP = 2;
	public static final int CONTROL_MODE_TEST_NO_PID = 3;
	public static final int CONTROL_MODE_TEST_PID = 4;
	public static int controlMode;

	@Override
	public void robotInit() {

		inst = NetworkTableInstance.getDefault();
		ntData = new Data(inst);
		ntInfo = new NTInfo(inst);

		driveTrain = new Drive();
		driveCamera = new Camera("Drive");
		hatchMechanism = new HatchMechanism();
		suctionCup = new SuctionCup();
		manualElevator = new Elevator();
		arm = new PIDArm();
		elevator = new PIDElevator();
		c = new Compressor(RobotMap.COMPRESSOR_ID);

		oi = new OI(); //instantiate this last
	
		c.setClosedLoopControl(true);
	}

	@Override
	public void robotPeriodic() {
		allPeriodic();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// Make sure nothing is moving
		this.initMechanisms();

		// Set up the auto controls
		setControlMode(Robot.CONTROL_MODE_AUTO);

		// Init hatch
		PistonExtend p = new PistonExtend();
		Scheduler.getInstance().add(p);
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		setControlMode(Robot.CONTROL_MODE_TELEOP);
		// ElevatorUp e = new ElevatorUp();
		// Scheduler.getInstance().add(e);
	}

	@Override
	public void teleopPeriodic() {
		allPeriodic();
		//System.out.println(elevator.log());
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		checkControlMode();
		Scheduler.getInstance().run();
	}

	private void initMechanisms() {
		// Init the mechanisms
		hatchMechanism.HatchRetract();
		hatchMechanism.PistonRetract();
		suctionCup.stop();
		arm.stop();
		driveTrain.stop();
		elevator.stop();
	}

	@Override
	public void testInit(){
		this.initMechanisms();

		// Default the mode to test without PID
		setControlMode(Robot.CONTROL_MODE_TEST_NO_PID);
	}

	public void allPeriodic() {
		ntInfo.update();
	}

	public void toggleCompressor(){
		this.toggleCompressor = !toggleCompressor;
		c.setClosedLoopControl(toggleCompressor);
    }

	private void checkControlMode() {
		try {
			int networkControlMode = Integer.parseInt(ntData.getControlMode().getString("2"));
			if (controlMode != networkControlMode) {
				setControlMode(networkControlMode);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void setControlMode(int cm) {
		controlMode = cm;
		switch (controlMode) {
		case Robot.CONTROL_MODE_AUTO:
			OI.configureControlModeAuto();
			break;
		case Robot.CONTROL_MODE_TELEOP:
			OI.configureControlModeTeleop();
			break;
		case Robot.CONTROL_MODE_TEST_NO_PID:
			OI.configureControlModeTestNoPID();
			break;
		case Robot.CONTROL_MODE_TEST_PID:
			OI.configureControlModeTestPID();
			break;
		}
		ntData.getControlMode().setNumber(controlMode);
	}
}
