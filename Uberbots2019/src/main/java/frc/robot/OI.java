/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.ToggleHatch;
import frc.robot.commands.TogglePiston;
import frc.robot.commands.ToggleSuction;
import frc.robot.commands.LowerArm;
import frc.robot.commands.RaiseArm;
import frc.robot.commands.ElevatorUp;
import frc.robot.commands.ElevatorDown;
import frc.robot.commands.SwitchCamera;

public class OI {

  public static final int DRIVER_1 = 0;
  public static final int DRIVER_2 = 1;

  public static final int A_BUTTON = 1;
  public static final int B_BUTTON = 2;
  public static final int X_BUTTON = 3;
  public static final int Y_BUTTON = 4;
  public static final int LEFT_BUTTON = 5;
  public static final int RIGHT_BUTTON = 6;
  public static final int BACK_BUTTON = 7;
  public static final int START_BUTTON = 8;
  public static final int LEFT_JOYSTICK_BUTTON = 9;
  public static final int RIGHT_JOYSTICK_BUTTON = 10;

  public static Joystick joystick = new Joystick(OI.DRIVER_1);

  public static Button[][] joystickButtons = {{
    null,
    new JoystickButton(joystick, OI.A_BUTTON),
    new JoystickButton(joystick, OI.B_BUTTON),
    new JoystickButton(joystick, OI.X_BUTTON),
    new JoystickButton(joystick, OI.Y_BUTTON),
    new JoystickButton(joystick, OI.LEFT_BUTTON),
    new JoystickButton(joystick, OI.RIGHT_BUTTON),
    new JoystickButton(joystick, 7),
    new JoystickButton(joystick, 8),
    new JoystickButton(joystick, OI.LEFT_JOYSTICK_BUTTON),
    new JoystickButton(joystick, OI.RIGHT_JOYSTICK_BUTTON),
    new JoystickButton(joystick, 11),
    new JoystickButton(joystick, 12),
    
  },{}
  };

  public OI(){}

  public static Joystick getJoystick(){
    return joystick;
  }

  public static Joystick getJoystick2(){
    return null;
  }

  private static void configurePneumaticButtons(int driver) {
    joystickButtons[driver][OI.B_BUTTON].whenPressed(new ToggleHatch());
    joystickButtons[driver][OI.Y_BUTTON].whenPressed(new ToggleSuction());
    joystickButtons[driver][OI.BACK_BUTTON].whenPressed(new TogglePiston());
    joystickButtons[driver][OI.START_BUTTON].whenPressed(new SwitchCamera());
  }

  private static void configureDriverArm(int driver) {
    joystickButtons[driver][OI.LEFT_BUTTON].toggleWhenPressed(new LowerArm());
    joystickButtons[driver][OI.RIGHT_BUTTON].toggleWhenPressed(new RaiseArm());
  }

  private static void configureDriverElevator(int driver) {
    joystickButtons[driver][OI.A_BUTTON].toggleWhenPressed(new ElevatorUp());
    joystickButtons[driver][OI.X_BUTTON].toggleWhenPressed(new ElevatorDown());
  }

  public static void configureControlModeAuto() {
    // Set up OI for auto
    //Scheduler.getInstance().removeAll();
    Scheduler.getInstance().add(Robot.driveTrain.getDefaultCommand());
    OI.configurePneumaticButtons(OI.DRIVER_1);
    OI.configureDriverArm(OI.DRIVER_1);
    OI.configureDriverElevator(OI.DRIVER_1);
  }

	public static void configureControlModeTeleop() {
    // Set up OI for teleop
    //Scheduler.getInstance().removeAll();
    //Scheduler.getInstance().add(Robot.driveTrain.getDefaultCommand());
    OI.configurePneumaticButtons(OI.DRIVER_1);
    OI.configureDriverArm(OI.DRIVER_1);
    OI.configureDriverElevator(OI.DRIVER_1);
	}

	public static void configureControlModeTestNoPID() {
		// Set up OI for testing without PID
    //Scheduler.getInstance().removeAll();

    // Disarm PID and set up for PWM
    Robot.driveTrain.usePID(false);

    /*
		 * Drivetrain: driver 1, left stick
		 * Elevator: driver 1, button 11=up, 12=down
		 * Arm: driver 1, button 8=clockwise, left push button=counterclockwise
		 * Suction cup: driver 1, right push button
		 * Hatch: driver 1, right button
		 * Init hatch: driver 1, right push button
		 */
    Scheduler.getInstance().add(Robot.driveTrain.getDefaultCommand());
    OI.configurePneumaticButtons(OI.DRIVER_1);
    OI.configureDriverArm(OI.DRIVER_1);
    OI.configureDriverElevator(OI.DRIVER_1);
	}

	public static void configureControlModeTestPID() {
		// Set up OI for testing PIDs
    //Scheduler.getInstance().removeAll();

    // Enable PID and set up PID values
    Robot.driveTrain.usePID(true);
    /*
		 * Drivetrain: driver 1, left stick
		 * Elevator: driver 1, button A=up, B=down
		 * Arm: driver 1, button 8=clockwise, left push button=counterclockwise
		 * Suction cup: driver 1, right push button
		 * Hatch: driver 1, B button
		 * Init hatch: driver 1, Y button
		 */
    OI.configurePneumaticButtons(OI.DRIVER_1);
    OI.configureDriverArm(OI.DRIVER_1);
    OI.configureDriverElevator(OI.DRIVER_1);
	}

}
