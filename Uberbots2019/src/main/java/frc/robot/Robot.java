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
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.Drive;
import frc.robot.vision.Camera;
import frc.robot.data.Data;
import frc.robot.data.NTInfo;
import frc.robot.OI;
import frc.robot.subsystems.HatchMechanism;
import frc.robot.subsystems.SuctionCup;
//import frc.robot.subsystems.PIDElevator;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;
import frc.robot.commands.PistonExtend;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	// Operator Interface (joysticks, buttons, etc.)
	public static OI oi;

	// Control modes for operator interface
	public static final int CONTROL_MODE_AUTO = 1;
	public static final int CONTROL_MODE_TELEOP = 2;
	public static final int CONTROL_MODE_TEST_NO_PID = 3;
	public static final int CONTROL_MODE_TEST_PID = 4;
	public static int controlMode;

	// Communication
	private static NetworkTableInstance inst;
	public static Data ntData;
	public static NTInfo ntInfo;
	public static Camera camera;

	// Mechanisms
	public static Drive driveTrain;
	public static HatchMechanism hatchMechanism;
	public static SuctionCup suctionCup;
	public static Arm arm;
	public static Compressor c;
	public static Elevator elevator;

	private boolean toggleCompressor = true;

	/**
	 * Instantiates all subsystem, communication, and operator interface for robot.
	 */
	@Override
	public void robotInit() {
		// Communications
		inst = NetworkTableInstance.getDefault();
		ntData = new Data(inst);
		ntInfo = new NTInfo(inst);
		camera = new Camera();

		// Subsystems
		driveTrain = new Drive();
		hatchMechanism = new HatchMechanism();
		suctionCup = new SuctionCup();
		elevator = new Elevator();
		arm = new Arm();
		c = new Compressor(RobotMap.COMPRESSOR_ID);

		// Operator interface
		oi = new OI();
	
		c.setClosedLoopControl(true);
	}

	/**
	 * Callback for all modes (auto, teleop, test).
	 */
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

	/**
	 * Set up for running autonomous mode.
	 */
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

	/**
	 * Callback for running autonomous mode. We use command scheduling so it only needs to call the scheduler.
	 */
	@Override
	public void autonomousPeriodic() {
		c.setClosedLoopControl(true);
		Scheduler.getInstance().run();
	}

	/**
	 * Set up for running teleop mode.
	 */
	@Override
	public void teleopInit() {
		setControlMode(Robot.CONTROL_MODE_TELEOP);
	}

	/**
	 * Callback for running teleop mode. We use command scheduling so it only needs to call the scheduler.
	 */
	@Override
	public void teleopPeriodic() {
		allPeriodic();
		c.setClosedLoopControl(true);
		System.out.println(elevator.log());
		Scheduler.getInstance().run();
	}

	/**
	 * Callback for running test mode. Checks the control mode to switch control layout if needed.
	 * We use command scheduling so it only needs to call the scheduler.
	 */
	@Override
	public void testPeriodic() {
		checkControlMode();
		Scheduler.getInstance().run();
	}

	/**
	 * Initializes the subsystems.
	 */
	private void initMechanisms() {
		// Init the mechanisms
		hatchMechanism.HatchRetract();
		suctionCup.stop();
		arm.stop();
		driveTrain.stop();
		elevator.stop();
	}

	/**
	 * Set up test mode. Initialize subsystems and set the operator interface.
	 */
	@Override
	public void testInit(){
		this.initMechanisms();

		// Default the mode to test without PID
		setControlMode(Robot.CONTROL_MODE_TEST_NO_PID);
	}

	/**
	 * Makes sure the we're in closed loop and update NetworkTables
	 */
	public void allPeriodic() {
		c.setClosedLoopControl(true);
		ntInfo.update();
	}

	/**
	 * Toggle the compressor based on previous setting.
	 */
	public void toggleCompressor(){
		this.toggleCompressor = !toggleCompressor;
		c.setClosedLoopControl(toggleCompressor);
    }

	/**
	 * Use NetworkTables to get the ControlMode and set up the OI.
	 */
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

	/**
	 * Set the control mode using OI to reassign the operator interface commands.
	 * 
	 * @param cm	control mode id
	 */
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