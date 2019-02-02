package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;


public class LowerArm extends Command {
	private double THROTTLE = -0.75;

	protected static DigitalInput reverseLimitSwitch;

	public LowerArm(){
        requires(Robot.arm);

		reverseLimitSwitch = new DigitalInput(RobotMap.ARM_LIMIT_REVERSE);
	
        setInterruptible(true);
    }

    public boolean isFinished(){
        return reverseLimitSwitch.get();
    }

    @Override
  protected void execute() {
    Robot.arm.moveArm(THROTTLE);
  }

}
