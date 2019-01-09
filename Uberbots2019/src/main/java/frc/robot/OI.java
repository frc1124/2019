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

import frc.robot.commands.ArcadeDriveJoystick;

public class OI {
 
  public static Joystick joystick = new Joystick(0);;

  public Button[] joystickButtons = {
    null,
    new JoystickButton(joystick, 1),
    new JoystickButton(joystick, 2),
    new JoystickButton(joystick, 3),

  };

  public OI(){
    
    joystickButtons[1].toggleWhenPressed(new ArcadeDriveJoystick());
    joystickButtons[2].toggleWhenPressed(new HatchRelease());
    joystickButtons[3].toggleWhenPressed(new HatchRetract());

  }

  public Joystick getJoystick(){
    return joystick;
  }

}
