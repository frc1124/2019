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
import frc.robot.commands.SuctionCupStart;
import frc.robot.commands.HatchRelease;
import frc.robot.commands.HatchRetract;
import frc.robot.commands.PistonExtend;
import frc.robot.commands.PistonRetract;
import frc.robot.commands.LowerArm;
import frc.robot.commands.RaiseArm;
import frc.robot.commands.PIDTuner;

public class OI {
  public static Joystick joystick = new Joystick(0);;

  public Button[] joystickButtons = {
    null,
    new JoystickButton(joystick, 1),
    new JoystickButton(joystick, 2),
    new JoystickButton(joystick, 3),
    new JoystickButton(joystick, 4),
    new JoystickButton(joystick, 5),
    new JoystickButton(joystick, 6),
    new JoystickButton(joystick, 7),
    new JoystickButton(joystick, 8),
    new JoystickButton(joystick, 9),
    new JoystickButton(joystick, 10)
  };

  public OI(){
    
    joystickButtons[1].toggleWhenPressed(new ArcadeDriveJoystick());
    //joystickButtons[2].toggleWhenPressed(new HatchRelease());
    //joystickButtons[3].toggleWhenPressed(new HatchRetract());
    //joystickButtons[4].toggleWhenPressed(new PistonExtend());
    //joystickButtons[5].toggleWhenPressed(new PistonRetract());
    joystickButtons[5].toggleWhenPressed(new PIDTuner(4));
    //joystickButtons[8].toggleWhenPressed(new LowerArm());
    //joystickButtons[9].toggleWhenPressed(new RaiseArm());
    //joystickButtons[10].toggleWhenPressed(new SuctionCupStart());
  }

  public Joystick getJoystick(){
    return joystick;
  }

}
